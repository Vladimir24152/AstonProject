package org.example.io.scanner.impl;

import org.example.collection.StudentList;
import org.example.io.scanner.ScanStudents;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ScanStudentsFromConsoleTest {
    @Test
    @DisplayName("При вводе 2 студентов должен вернуть коллекцию из 2 студентов")
    void whenScanStudents2_thenReturnStudentListSize2() {
        int count = 2;
        String input = "Иван|Иванов|101|4.5|1234567|20|ул. Ленина 1;\n" +
                "Петр|Петров|101|4.7|1234567|21|ул. Пушкина 2;\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ScanStudents scanStudentsFromConsole = new ScanStudentsFromConsole();
        StudentList result = scanStudentsFromConsole.scanStudents(count);

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("При вводе 0 студентов должен вернуть пустую коллекцию")
    void whenScanStudents0_thenReturnEmptyStudentList() {
        int count = 0;

        ScanStudents scanStudentsFromConsole = new ScanStudentsFromConsole();
        StudentList result = scanStudentsFromConsole.scanStudents(count);

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("При отрицательного значения должен вернуть пустую коллекцию")
    void whenScanStudentsNegativeCount_thenReturnEmptyStudentList() {
        int count = -10;

        ScanStudents scanStudentsFromConsole = new ScanStudentsFromConsole();
        StudentList result = scanStudentsFromConsole.scanStudents(count);

        assertEquals(0, result.size());
    }
}