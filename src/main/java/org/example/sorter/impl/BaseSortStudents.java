package org.example.sorter.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.model.Student;
import org.example.sorter.SortStudents;

import java.util.stream.Collectors;

public class BaseSortStudents implements SortStudents {
    @Override
    public StudentList sortStudents(StudentList studentList) {

        Student[] arrayStudents = new Student[studentList.size()];
        for (int i = 0;i < arrayStudents.length; i++){
            arrayStudents[i] = studentList.get(i);
        }

        System.out.println();
        System.out.println(arrayStudents[0]);

        Student[] sortedArrayStudents = mergeSort(arrayStudents,0,studentList.size() - 1);

        System.out.println();
        System.out.println(sortedArrayStudents[0]);
        System.out.println();

        StudentList sortedStudentList = new StudentArrayList();
        for (int i = 0;i < sortedArrayStudents.length; i++){
            sortedStudentList.add(sortedArrayStudents[i]);
        }

        return sortedStudentList;
    }

    private Student[] mergeSort(Student[] source, int left, int right) {

        int delimiter = left + ((right - left) / 2) + 1;

        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }

        Student[] buffer = new Student[right - left + 1];

        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {

            if (delimiter > right || source[cursor].compareTo(source[delimiter]) < 0) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
        return source;
    }
}
