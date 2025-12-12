package org.example.io.scanner;

import org.example.collection.StudentList;

@FunctionalInterface
public interface ScanStudents {

    StudentList scanStudents(Integer count);
}
