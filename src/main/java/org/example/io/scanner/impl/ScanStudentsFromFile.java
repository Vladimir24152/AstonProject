package org.example.io.scanner.impl;

import org.example.collection.StudentList;
import org.example.io.TxtUtils;
import org.example.io.scanner.ScanStudents;
import org.example.model.Student;

import java.util.Arrays;
import java.util.List;

public class ScanStudentsFromFile implements ScanStudents {

    @Override
    public StudentList scanStudents(Integer count) {

        String dataFromTxt = TxtUtils.readFile("students_demo.txt");
        List<String> students = Arrays.asList(dataFromTxt.split("\\s*;\\s*"));

        for (int i = 0; i < count; i++) {
            if (i == students.size()) {
                break;
            }
            String[] element = students.get(i).split("\\|");

            String name = element[0];
            String lastname = element[1];
            Integer groupNumber = Integer.valueOf(element[2]);
            Double averageScore = Double.valueOf(element[3]);
            String gradeBookNumber = element[4];
            Integer age = Integer.valueOf(element[5]);
            String address = element[6];

            // Создаю объект Student
            Student student = new Student.Builder(name, lastname, groupNumber, averageScore, gradeBookNumber)
                    .buildAge(age)
                    .buildAddress(address)
                    .build();
            // Добавить студента в коллекцию

        }
        return null;
    }
}
