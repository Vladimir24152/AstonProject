package org.example.mapper;

import org.example.exceptions.IllegalStudentException;
import org.example.model.Student;

public class StudentMapperImpl implements StudentMapper{

    public Student toStudent(String string) throws IllegalStudentException {

        String[] elements = string.split(";")[0].split("\\|");
        if (elements.length < 5)
            throw new IllegalStudentException("Были некоректно введены данные");

        String name = elements[0];
        String lastname = elements[1];
        Integer groupNumber = Integer.valueOf(elements[2]);
        Double averageScore = Double.valueOf(elements[3]);
        String gradeBookNumber = elements[4];

        Student.Builder studentBuilder = new Student.Builder(name, lastname, groupNumber, averageScore, gradeBookNumber);

        if (elements.length > 5) {
            Integer age = Integer.valueOf(elements[5]);
            studentBuilder.buildAge(age);
        }

        if (elements.length > 6) {
            String address = elements[6];
            studentBuilder.buildAddress(address);
        }

        return studentBuilder.build();
    }
}
