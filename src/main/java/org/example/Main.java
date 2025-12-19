package org.example;

import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.printer.StudentPrinter;
import org.example.io.printer.impl.PrintStudentsToConsole;
import org.example.io.printer.impl.PrintStudentsToFile;
import org.example.io.scanner.StudentScanner;
import org.example.io.scanner.impl.ScanStudentsFromConsole;
import org.example.io.scanner.impl.ScanStudentsFromFile;
import org.example.io.scanner.impl.ScanStudentsRandom;
import org.example.model.Student;
import org.example.sorter.StudentSorter;
import org.example.sorter.impl.BaseSortStudents;
import org.example.sorter.impl.CustomSortStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StudentScanner studentScanner ;
    static StudentList studentList;
    static Integer countStudentForScan;
    static StudentList sortedStudentList;
    static StudentSorter studentSorter;
    static StudentPrinter studentPrinter;
    static Boolean isRunning = true;
    static BufferedReader consoleReader;

    public static void main(String[] args) {

        try {
            // Создаем 10 студентов группы 101
            for (int i = 1; i <= 10; i++) {
                Student student = new Student.Builder(
                        "Имя" + i,
                        "Фамилия" + i,
                        101,
                        3.0 + (i % 4) * 0.5, // Оценки от 3.0 до 4.5
                        String.format("GB%05d", i) // Номер зачетки в формате GB00001
                )
                        .buildAge(18 + i % 5) // Возраст от 18 до 22
                        .buildAddress("ул. Пушкина, д. " + i)
                        .build();

                sortedStudentList.add(student);
            }

            // Создаем 10 студентов группы 202
            for (int i = 11; i <= 20; i++) {
                Student student = new Student.Builder(
                        "Имя" + i,
                        "Фамилия" + i,
                        202,
                        3.5 + ((i - 10) % 3) * 0.5, // Оценки от 3.5 до 4.5
                        String.format("GB%05d", i) // Номер зачетки в формате GB00011
                )
                        .buildAge(19 + (i - 10) % 4) // Возраст от 19 до 22
                        .buildAddress("ул. Лермонтова, д. " + (i - 10))
                        .build();

                sortedStudentList.add(student);
            }
        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sortedStudentList.contains(101,2));

//            consoleReader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            while (isRunning){
//                studentScanner = toChooseStudentScanner();
//                if (!isRunning) break;
//                countStudentForScan = requestingCountToScan();
//                studentList = studentScanner.getStudents(countStudentForScan);
//
//                studentSorter = toChooseStudentSorter();
//                if (!isRunning) break;
//                sortedStudentList = studentSorter.sortStudents(studentList);
//
//                studentPrinter = toChooseStudentPrinter();
//                if (!isRunning) break;
//                studentPrinter.printStudents(sortedStudentList);
//                System.out.println("Список студентов отсортирован!");
//                System.out.println();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }finally {
//            if (consoleReader != null) {
//                try {
//                    consoleReader.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
    }

    private static StudentScanner toChooseStudentScanner() {
        while (isRunning) {
            String string = getDataFromTheUser(
                    "Выберите способ ввода списка студентов (введите число):",
                    "1 - Из файла;",
                    "2 - Из консоли;",
                    "3 - Рандомный набор студентов;",
                    "x - завершить работу приложения.");
            switch (string){
                case "1":
                    return new StudentScanner(new ScanStudentsFromFile());
                case "2":
                    return new StudentScanner(new ScanStudentsFromConsole());
                case "3":
                    return new StudentScanner(new ScanStudentsRandom());
                case "x":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ведено неверное значение, повторите попытку");
            }
        }
        return null;
    }

    private static Integer requestingCountToScan() {
        while (true) {
            try {
                Integer count = Integer.parseInt(getDataFromTheUser("Введите количество студентов для сканирования:"));
                if (count <= 0) throw new NumberFormatException("Ошибка при вводе, повторите попытку");
                return count;
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static StudentSorter toChooseStudentSorter() {
        while (isRunning) {
            String string = getDataFromTheUser(
                    "Выберите способ сортировки списка студентов (введите число):",
                    "1 - Стандартная сортировка по 3 полям (Номер группы, Средний балл, Номер зачетной книжки);",
                    "2 - Сортировка при которой студенты с нечетным номером группы остаются на исходных позициях ;",
                    "x - завершить работу приложения.");

            switch (string){
                case "1":
                    return new StudentSorter(new BaseSortStudents());
                case "2":
                    return new StudentSorter(new CustomSortStudents());
                case "x":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ведено неверное значение, повторите попытку");
            }
        }
        return null;
    }

    private static StudentPrinter toChooseStudentPrinter() {
        while (isRunning) {
            String string = getDataFromTheUser(
                    "Выберите место сохранения отсортированного списка студентов (введите число):",
                    "1 - в файл;",
                    "2 - в консоль;",
                    "x - завершить работу приложения.");

            switch (string){
                case "1":
                    return new StudentPrinter(new PrintStudentsToFile());
                case "2":
                    return new StudentPrinter(new PrintStudentsToConsole());
                case "x":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ведено неверное значение, повторите попытку");
            }
        }
        return null;
    }

    private static String getDataFromTheUser(String ... lines){
        for (int i = 0; i < lines.length; i++){
            System.out.println(lines[i]);
        }
        try {
            return consoleReader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }
        return "0";
    }
}