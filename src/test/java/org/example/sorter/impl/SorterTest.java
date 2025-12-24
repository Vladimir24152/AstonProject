package org.example.sorter.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.model.Student;
import org.example.sorter.SortStudents;
import org.junit.jupiter.api.BeforeEach;

public class SorterTest {

    protected StudentList studentList = new StudentArrayList();

    protected SortStudents sortStudents;

    @BeforeEach
    void setUp(){
        try {
            for (int i = 10; i > 0; i--){
                studentList.add(new Student.Builder("name" + i,
                        "lastname" + i,
                        100 + i,
                        2.1 + (i / 10),
                        Integer.toString(1000000 + i))
                        .buildAge(20 + i)
                        .buildAddress("address")
                        .build());
            }
        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        }
    }
}
