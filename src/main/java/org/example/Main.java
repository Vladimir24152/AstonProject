package org.example;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.printer.StudentPrinter;
import org.example.io.printer.impl.PrintStudentsToConsole;
import org.example.io.printer.impl.PrintStudentsToFile;
import org.example.io.scanner.StudentScanner;
import org.example.io.scanner.impl.ScanStudentsFromConsole;
import org.example.io.scanner.impl.ScanStudentsFromFile;
import org.example.io.scanner.impl.ScanStudentsRandom;
import org.example.sorter.StudentSorter;
import org.example.sorter.impl.BaseSortStudents;
import org.example.sorter.impl.CustomSortStudents;

import java.util.Scanner;

public class Main {

    static StudentScanner studentScanner ;
    static StudentList studentList;
    static Integer countStudentForScan;
    static StudentList sortedStudentList;
    static StudentSorter studentSorter;
    static StudentPrinter studentPrinter;
    static Boolean isRunning = true;
    static Scanner consoleReader;

    public static void main(String[] args) {
        consoleReader = new Scanner(System.in);
        while (isRunning){
            studentScanner = toChooseStudentScanner();
            if (!isRunning) break;
            countStudentForScan = requestingCountToScan();
            studentList = studentScanner.getStudents(countStudentForScan);

            studentSorter = toChooseStudentSorter();
            if (!isRunning) break;
            sortedStudentList = studentSorter.sortStudents(studentList);

            toChooseCountOfNumberCroup();

            studentPrinter = toChooseStudentPrinter();
            if (!isRunning) break;
            studentPrinter.printStudents(sortedStudentList);
            System.out.println("Список студентов отсортирован!");
            System.out.println();
        }
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
                System.err.println("Ведено неверное значение, повторите попытку");
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
                System.err.println("Ведено неверное значение, повторите попытку");
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
                System.err.println("Ведено неверное значение, повторите попытку");
        }
    }
    return null;
}

private static String getDataFromTheUser(String ... lines){
    for (int i = 0; i < lines.length; i++){
        System.out.println(lines[i]);
    }
    return consoleReader.nextLine();
}

private static void toChooseCountOfNumberCroup() {
    while (true) {
        String string = getDataFromTheUser(
                "Проверить количиство студентов в группе. Введите номер группы:",
                "q - продолжить далее");
        if (string.equals("q")) {
            break;
        }
        try {
            Integer count = sortedStudentList.contains(Integer.parseInt(string));
            if (count == 0) {
                System.out.println("Такой группы не найдено");
            }else {
                System.out.println(String.format("В этой группе %d студентов", count));
            }
        } catch (NumberFormatException e) {
            System.err.println("Ведено неверное значение, повторите попытку");
        }
    }
}
}