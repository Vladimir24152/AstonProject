package org.example.io.scanner.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.io.scanner.ScanStudents;
import org.example.model.Student;

import java.util.Scanner;

public class ScanStudentsFromConsole implements ScanStudents {
    @Override
    public StudentList scanStudents(Integer count) {
        Scanner scanner = new Scanner(System.in);
        StudentList students = new StudentArrayList();

        for (int i = 0; i < count; i++) {
            String studentString = scanner.nextLine();
            String[] elements = studentString.split("\\|");

            String name = elements[0];
            String lastName = elements[1];
            Integer groupNumber = Integer.parseInt(elements[2]);
            Double averageScore = Double.parseDouble(elements[3]);
            String gradeBookNumber = elements[4];
            Integer age = Integer.parseInt(elements[5]);
            String address = elements[6];

            students.add(new Student.Builder(name, lastName, groupNumber, averageScore, gradeBookNumber)
                            .buildAge(age)
                            .buildAddress(address)
                            .build()
            );
        }

        return students;
    }
}
