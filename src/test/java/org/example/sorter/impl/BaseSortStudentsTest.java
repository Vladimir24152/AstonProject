package org.example.sorter.impl;

import org.example.collection.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseSortStudentsTest extends SorterTest{

    private StudentList sortedStudentList;

    @Test
    void whenSortedSize10_thenReturnStudentListSize10(){
        sortStudents = new BaseSortStudents();

        assertEquals(10, sortStudents.sortStudents(studentList).size());
    }

    @Test
    void whenSortedStudents_thenReturnSortedStudentList(){
        sortStudents = new BaseSortStudents();
        sortedStudentList = sortStudents.sortStudents(studentList);

        for (int i = 0; i < studentList.size() - 1; i++){
            assertTrue((sortedStudentList.get(i).compareTo(sortedStudentList.get(i + 1))) < 0);
        }
        assertEquals(10, sortStudents.sortStudents(studentList).size());
    }
}