package org.example.io.printer.impl;

import org.example.collection.StudentList;
import org.example.io.printer.PrintStudents;

public class PrintStudentsToConsole implements PrintStudents {
    @Override
    public void printStudents(StudentList studentList) {
        if (studentList.size() > 0)
            studentList.stream().forEach(System.out::println);
        else
            System.out.println("Не было найдено студентов!");
    }
}
