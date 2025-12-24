package org.example.sorter.impl;

import org.example.collection.StudentList;
import org.example.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSortStudentsTest extends SorterTest{

    private StudentList sortedStudentList;

    @Test
    void whenSortedSize10_thenReturnStudentListSize10(){
        sortStudents = new CustomSortStudents();

        assertEquals(10, sortStudents.sortStudents(studentList).size());
    }

    @Test
    void whenSortedStudents_thenReturnSortedStudentList(){
        sortStudents = new CustomSortStudents();
        sortedStudentList = sortStudents.sortStudents(studentList);
        Student student = null;
        for (int i = 0; i < studentList.size() ; i++){
            if (sortedStudentList.get(i).getGroupNumber() % 2 == 0){
                if (student == null){
                    student = sortedStudentList.get(i);
                }else {
                    assertTrue((student.compareTo(sortedStudentList.get(i))) < 0);
                    student = sortedStudentList.get(i);
                }
            }
        }
        assertEquals(10, sortStudents.sortStudents(studentList).size());
    }
}