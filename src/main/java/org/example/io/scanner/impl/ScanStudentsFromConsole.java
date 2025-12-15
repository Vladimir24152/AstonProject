package org.example.io.scanner.impl;

import org.example.collection.StudentArrayListCollector;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.scanner.ScanStudents;
import org.example.mapper.StudentMapper;
import org.example.mapper.StudentMapperImpl;
import org.example.model.Student;

import java.util.Scanner;
import java.util.stream.Stream;

public class ScanStudentsFromConsole implements ScanStudents {
    StudentMapper studentMapper = new StudentMapperImpl();
    Scanner scanner = new Scanner(System.in);

    @Override
    public StudentList scanStudents(Integer count) {
        StudentList students = Stream.generate(this::scanStudent)
                .limit(count)
                .collect(new StudentArrayListCollector());

        return students;
    }

    private Student scanStudent() {
        Student student = null;

        // цикл, пока не будет создан корректный студент
        do {
            try {
                String studentString = scanner.nextLine();
                student = studentMapper.toStudent(studentString);
            } catch (IllegalStudentException e) {
                System.err.println(e.getMessage());
                System.out.println("Попробуйте ввести данные заново");
            }
        } while (student == null);

        return student;
    }
}
