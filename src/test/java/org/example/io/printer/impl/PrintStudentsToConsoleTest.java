package org.example.io.printer.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.printer.PrintStudents;
import org.example.mapper.StudentMapper;
import org.example.mapper.StudentMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrintStudentsToConsoleTest {
    private StudentMapper studentMapper;
    private PrintStudents printStudentsToConsole;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapperImpl();
        printStudentsToConsole = new PrintStudentsToConsole();
    }

    @Test
    @DisplayName("При коллекции из 2 студентов должен вывести 2 студентов")
    void whenPrintStudents2Students_thenPrint2Students() throws IllegalStudentException {
        StudentList students = new StudentArrayList();
        students.add(studentMapper
                .toStudent("Владимир|Горлов|101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;"));
        students.add(studentMapper
                .toStudent("Виктория|Яковлева|102|4.9|7654321|22|Саратов, ул. Саратовская, д10, кв. 255;"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        printStudentsToConsole.printStudents(students);
        String output = outputStream.toString();
        long lineCount = output.lines().count();
        assertEquals(2, lineCount);
    }
}