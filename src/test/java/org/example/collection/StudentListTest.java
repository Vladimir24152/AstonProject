package org.example.collection;


import org.example.exceptions.IllegalStudentException;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование коллекции")
class StudentListTest {

    private StudentList studentList;

    private Student testStudent;

    @BeforeEach
    void setUp(){
        try {
            studentList = new StudentArrayList();
            testStudent = new Student.Builder("name","lastname", 101, 4.1,"1111111")
                    .buildAge(20)
                    .buildAddress("address1")
                    .build();
        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("При добавлении студента должен вернуть размер равный 1")
    void whenAddStudent_SizeIs1(){
        studentList.add(testStudent);
        assertEquals(1, studentList.size());
    }

    @Test
    @DisplayName("При очистки коллекции размер коллекции должен быть 0")
    void whenClean_SizeIs0(){
        studentList.add(testStudent);
        studentList.add(testStudent);
        studentList.add(testStudent);

        studentList.clean();
        assertEquals(0, studentList.size());
    }

    @Test
    @DisplayName("При добавлении студента должен вернуть его же")
    void whenAddAndGetStudent_thenReturnStudent(){
        studentList.add(testStudent);

        assertEquals(studentList.get(0), testStudent);
    }

    @Test
    @DisplayName("При добавлении студента с номером группы 101, contains должен ввернуть 1")
    void whenAddStudentWithGroupNumber101_thenReturn1(){
        studentList.add(testStudent);

        assertEquals(1,studentList.contains(testStudent.getGroupNumber()));
    }
}