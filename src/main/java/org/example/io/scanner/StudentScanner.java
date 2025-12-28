package org.example.io.scanner;

import org.example.collection.StudentList;

public class StudentScanner {

    private ScanStudents scanStudents;

    public StudentScanner(ScanStudents scanStudents) {
        this.scanStudents = scanStudents;
    }

    public StudentList getStudents(Integer count){
        return scanStudents.scanStudents(count);
    }
}
