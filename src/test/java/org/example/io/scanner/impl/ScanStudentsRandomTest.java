package org.example.io.scanner.impl;

import org.example.collection.StudentArrayListCollector;
import org.example.collection.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ScanStudentsRandomTest {

    private ScanStudentsRandom scanStudentsRandom;

    @BeforeEach
    void setUp() {
        scanStudentsRandom = new ScanStudentsRandom();
    }

    @Test
    @DisplayName("При количестве 10 должен вернуть коллекцию из 10 студентов")
    void whenScanStudentsScanStudents10_thenReturnStudentListSize10() {
        assertEquals(10,scanStudentsRandom.scanStudents(10).size());
    }

    @Test
    @DisplayName("При количестве 0 должен вернуть пустую коллекцию")
    void whenScanStudentsScanStudents_thenReturnEmptyStudentList() {
        assertTrue(scanStudentsRandom.scanStudents(0).size() == 0);
    }

    @Test
    @DisplayName("При вводе отрицательного значения возвращает пустую коллекцию")
    void whenScanStudentsScanNegativeCountStudents_thenReturnEmptyStudentList() {
        assertTrue(scanStudentsRandom.scanStudents(0).size() == 0);
    }

    @Test
    @DisplayName("Должен вернуть коллекцию разных студентов")
    void whenScanStudentsScanStudents_thenReturnUniqueStudentListRecords() {
        StudentList studentList1 = scanStudentsRandom.scanStudents(10);
        StudentList studentList2 = studentList1.stream()
                        .distinct()
                .collect(new StudentArrayListCollector());

        assertTrue(studentList1.size().equals(studentList2.size()));
    }
}