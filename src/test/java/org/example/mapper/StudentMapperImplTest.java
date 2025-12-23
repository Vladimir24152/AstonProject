package org.example.mapper;

import org.example.exceptions.IllegalStudentException;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperImplTest {
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapperImpl();
    }

    @Test
    @DisplayName("При валидном вводе студента должен возвращать экземпляр студента")
    void whenToStudentGetValidStudent_thenReturnStudent() throws IllegalStudentException {
        String stringStudent = "Владимир|Горлов|101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";
        Student student = studentMapper.toStudent(stringStudent);

        assertNotNull(student);
    }

    @Test
    @DisplayName("При заполнении только обязательных полей должен возвращать экземпляр студента")
    void whenToStudentGetRequiredFields_thenReturnStudent() throws IllegalStudentException {
        String stringStudent = "Владимир|Горлов|101|4.5|1234567;";
        Student student = studentMapper.toStudent(stringStudent);

        assertNotNull(student);
    }

    @Test
    @DisplayName("При ввводе пустой строки должен выбрасывать IllegalStudentException")
    void whenToStudentGetEmptyString_thenReturnException() {
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(""));
    }

    @Test
    @DisplayName("При невалидном вводе студента должен выбрасывать IllegalStudentException")
    void whenToStudentGetInvalidStudent_thenThrowException() {
        String stringStudent1 = "В|Горлов|101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent1));

        String stringStudent2 = "Владимир|Г|101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent2));

        String stringStudent3 = "Владимир|Горлов|-101|4.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent3));

        String stringStudent4 = "Владимир|Горлов|101|40.5|1234567|23|Саратов, ул. Саратовская, д5, кв. 30;";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent4));

        String stringStudent5 = "Владимир|Горлов|101|4.5|123|23|Саратов, ул. Саратовская, д5, кв. 30;";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent5));

        String stringStudent6 = "Владимир|Горлов|101|4.5|1234567|-23|Саратов, ул. Саратовская, д5, кв. 30;";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent6));

        String stringStudent7 = "Владимир|Горлов|101|4.5|1234567|23|" + new String(new char[300]) + ";";
        assertThrows(IllegalStudentException.class, () -> studentMapper.toStudent(stringStudent7));
    }
}