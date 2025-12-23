package org.example.io.scanner.impl;

import org.example.collection.StudentArrayList;
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
    int validStudents = 0;      // счетчик корректных студентов

    @Override
    public StudentList scanStudents(Integer count) {
        if (count < 0)
            return new StudentArrayList();

        System.out.println("Введите данные студентов (в формате - имя|фамилия|группа" +
                "|средний балл|номер зачетки|возраст|адрес;):");
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
                validStudents++;
                System.out.print(validStudents + ") ");
                String studentString = scanner.nextLine().split(";")[0];
                student = studentMapper.toStudent(studentString);
            } catch (IllegalStudentException e) {
                validStudents--;
                System.err.println(e.getMessage());
                System.out.println("Попробуйте ввести данные заново");
            }
        } while (student == null);

        return student;
    }
}
