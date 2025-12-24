package org.example.io.printer.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
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
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PrintStudentsToFileTest {

    @Mock
    private Scanner scanner;

    private File file = new File("src/main/resources/test1.txt");

    private PrintStudentsToFile printStudentsToFile;
    private Student student;
    private StudentList studentList;

    @BeforeEach
    void setUp(){
        try {
            if (file.exists()) {
                Files.delete(file.toPath());
            }
            studentList = new StudentArrayList();
            student = new Student.Builder("Владимир","Горлов",101,4.5,"1234567")
                    .buildAge(23)
                    .buildAddress("Саратов, ул. Саратовская, д5, кв. 30")
                    .build();
            printStudentsToFile = new PrintStudentsToFile();
            printStudentsToFile.setScanner(scanner);
            when(scanner.nextLine()).thenReturn("test1");
            studentList.add(student);

        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("При отсутстввии файла должен создать файл и записывать в него")
    void whenFileIsNotExist_thenCreateFileAndWriteLine() {
        try {
            Files.deleteIfExists(file.toPath());
            printStudentsToFile.printStudents(studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(file.exists());

        String content = TxtUtils.readFile("test1");
        assertTrue(content.contains("Владимир"));
    }

    @Test
    @DisplayName("При наличии файла должен записывать в него")
    void whenFileIsExist_thenAndWriteLine() {
        when(scanner.nextLine()).thenReturn("test1");
        printStudentsToFile.setScanner(scanner);

        printStudentsToFile.printStudents(studentList);

        String fileContent = TxtUtils.readFile("test1");
        assertTrue(fileContent.contains("Владимир|Горлов"));
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