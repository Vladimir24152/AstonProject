package org.example.mapper;

import org.example.exceptions.IllegalStudentException;
import org.example.model.Student;

public class StudentMapperImpl implements StudentMapper{

    public Student toStudent(String string) throws IllegalStudentException {

        String[] element = string.split("\\|");

        if (element.length < 5) { // Минимальное количество полей
            throw new IllegalStudentException("Недостаточно данных в строке: " + element);
        }

        String name = element[0];
        String lastname = element[1];
        Integer groupNumber = Integer.valueOf(element[2]);
        Double averageScore = Double.valueOf(element[3]);
        String gradeBookNumber = element[4];
        Integer age = Integer.valueOf(element[5]);
        String address = element[6];

        Student student = new Student.Builder(name, lastname, groupNumber, averageScore, gradeBookNumber)
                .buildAge(age)
                .buildAddress(address)
                .build();

        return student;
    }
}
