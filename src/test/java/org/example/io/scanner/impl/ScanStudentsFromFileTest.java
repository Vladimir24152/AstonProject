package org.example.io.scanner.impl;

import org.example.exceptions.IllegalStudentException;
import org.example.io.TxtUtils;
import org.example.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScanStudentsFromFileTest {

    private File file = new File("src/main/resources/test1.txt");
    private String line = "Владимир|Горлов|101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";
    private Student student;

    @Mock
    private Scanner scanner;

    ScanStudentsFromFile scanStudentsFromFile;

    @BeforeEach
    void setUp(){
        try {
            Files.deleteIfExists(file.toPath());
            Files.createDirectories(Paths.get("src/main/resources/"));
            Files.createFile(file.toPath());
            scanStudentsFromFile = new ScanStudentsFromFile();
            student = new Student.Builder("Владимир","Горлов",101,4.5,"1234567")
                    .buildAge(23)
                    .buildAddress("Саратов, ул. Саратовская, д5, кв. 30")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("При количестве 3 должен вернуть коллекцию из 3 студентов")
    void whenScanStudentsScanStudents3_thenReturnStudentListSize3() {
        when(scanner.nextLine()).thenReturn("test1");
        scanStudentsFromFile.setScanner(scanner);
        TxtUtils.writeLine(line,"test1");
        TxtUtils.writeLine(line,"test1");
        TxtUtils.writeLine(line,"test1");
        assertEquals(3,scanStudentsFromFile.scanStudents(3).size());
    }

    @Test
    @DisplayName("При всесении записи о студенте в файл , должен ввернуть коллекцию с ним")
    void whenScanStudent_thenReturnStudentListWithStudent() {
        when(scanner.nextLine()).thenReturn("test1");
        scanStudentsFromFile.setScanner(scanner);
        TxtUtils.writeLine(line,"test1");

        assertEquals(scanStudentsFromFile.scanStudents(1).get(0),student);
    }

    @AfterEach
    void theEnd(){
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}