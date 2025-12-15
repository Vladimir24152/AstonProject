package org.example.io.printer.impl;

import org.example.collection.StudentList;
import org.example.io.TxtUtils;
import org.example.io.printer.PrintStudents;

import java.util.Scanner;

public class PrintStudentsToFile implements PrintStudents {
    @Override
    public void printStudents(StudentList studentList) {
        System.out.println("Введите название файла, без расширения:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        studentList.stream()
                .forEach(student -> TxtUtils.writeLine(student.toString(), fileName));

    }
}
