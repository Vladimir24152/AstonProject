package org.example.sorter;

import org.example.collection.StudentList;

@FunctionalInterface
public interface SortStudents {

    StudentList sortStudents(StudentList studentList);
}
