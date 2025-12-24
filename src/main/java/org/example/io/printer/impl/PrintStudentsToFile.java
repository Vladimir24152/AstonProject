package org.example.io.printer.impl;

import org.example.collection.StudentList;
import org.example.io.TxtUtils;
import org.example.io.printer.PrintStudents;

import java.util.Scanner;

public class PrintStudentsToFile implements PrintStudents {

    private Scanner scanner;

    public PrintStudentsToFile() {
        this.scanner = new Scanner(System.in);
    }

    public PrintStudentsToFile(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printStudents(StudentList studentList) {
        System.out.println("Введите название файла, без расширения:");
        String fileName = scanner.nextLine();

        studentList.stream()
                .forEach(student -> TxtUtils.writeLine(student.toString(), fileName));
    }
}
