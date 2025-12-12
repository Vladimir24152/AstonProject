package org.example.io.printer;

import org.example.collection.StudentList;

@FunctionalInterface
public interface PrintStudents {

    void printStudents(StudentList studentList);
}
