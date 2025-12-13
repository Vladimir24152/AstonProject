package org.example.sorter.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.model.Student;
import org.example.sorter.SortStudents;

import java.util.stream.Collectors;

import static org.example.sorter.util.SortedUtil.mergeSort;

public class BaseSortStudents implements SortStudents {
    @Override
    public StudentList sortStudents(StudentList studentList) {

        Student[] arrayStudents = new Student[studentList.size()];
        for (int i = 0;i < arrayStudents.length; i++){
            arrayStudents[i] = studentList.get(i);
        }

        Student[] sortedArrayStudents = mergeSort(arrayStudents,0,studentList.size() - 1);

        StudentList sortedStudentList = new StudentArrayList();
        for (int i = 0;i < sortedArrayStudents.length; i++){
            sortedStudentList.add(sortedArrayStudents[i]);
        }

        return sortedStudentList;
    }
}
