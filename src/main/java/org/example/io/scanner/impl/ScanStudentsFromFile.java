package org.example.io.scanner.impl;

import org.example.mapper.StudentMapper;
import org.example.collection.StudentArrayListCollector;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.TxtUtils;
import org.example.io.scanner.ScanStudents;
import org.example.mapper.StudentMapperImpl;
import org.example.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScanStudentsFromFile implements ScanStudents {

    StudentMapper studentMapper = new StudentMapperImpl();

    @Override
    public StudentList scanStudents(Integer count) {
        StudentList result;

        System.out.println("Введите название файла, без расширения:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        String dataFromTxt = TxtUtils.readFile(String.format("%s", fileName));
        List<String> students = Arrays.asList(dataFromTxt.split("\\s*;\\s*"));

        result = students.stream()
                .map(string -> studentMapper.toStudent(string))
                .limit(count)
                .collect(new StudentArrayListCollector());

//        for (int i = 0; i < count; i++) {
//            if (i == students.size()) {
//                break;
//            }
//            String[] element = students.get(i).split("\\|");
//
//            String name = element[0];
//            String lastname = element[1];
//            Integer groupNumber = Integer.valueOf(element[2]);
//            Double averageScore = Double.valueOf(element[3]);
//            String gradeBookNumber = element[4];
//            Integer age = Integer.valueOf(element[5]);
//            String address = element[6];
//
//            // Создаю объект Student
//            Student student;
//            try {
//                student = new Student.Builder(name, lastname, groupNumber, averageScore, gradeBookNumber)
//                        .buildAge(age)
//                        .buildAddress(address)
//                        .build();
//            } catch (IllegalStudentException e) {
//                throw new RuntimeException(e);
//            }
//            // Добавить студента в коллекцию
//            result.add(student);
//        }
        return result;
    }
}
