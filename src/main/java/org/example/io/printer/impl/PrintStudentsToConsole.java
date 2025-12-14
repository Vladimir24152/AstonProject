package org.example.io.printer.impl;

import org.example.collection.StudentList;
import org.example.io.printer.PrintStudents;

public class PrintStudentsToConsole implements PrintStudents {
    @Override
    public void printStudents(StudentList studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }
}
