package org.example.io.printer;

import org.example.collection.StudentList;

public class StudentPrinter {
    private PrintStudents printStudents;

    public StudentPrinter(PrintStudents printStudents) {
        this.printStudents = printStudents;
    }

    public void setPrintStudents(PrintStudents printStudents) {
        this.printStudents = printStudents;
    }


    public void printStudents(StudentList sortedStudentList) {
        printStudents.printStudents(sortedStudentList);
    }
}
