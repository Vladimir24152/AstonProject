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

        return result;
    }
}
