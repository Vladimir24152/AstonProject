package org.example.sorter.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.model.Student;
import org.example.sorter.SortStudents;

import static org.example.sorter.util.SortedUtil.mergeSort;

public class CustomSortStudents implements SortStudents {
    @Override
    public StudentList sortStudents(StudentList studentList) {

        Student[] arrayStudents = new Student[studentList.size()];
        int countOfIndex = 0;
        int[] indexes = new int[studentList.size()];

        for (int i = 0;i < arrayStudents.length; i++){
            arrayStudents[i] = studentList.get(i);
            if ((studentList.get(i).getGroupNumber() % 2) == 0){
                indexes[countOfIndex] = i;
                countOfIndex++;
            }
        }

        Student[] arrayStudentsSort = new Student[countOfIndex];

        for (int i = 0;i < arrayStudentsSort.length; i++){
            arrayStudentsSort[i] = arrayStudents[indexes[i]];
        }
        arrayStudentsSort = mergeSort(arrayStudentsSort,0,arrayStudentsSort.length - 1);

        for (int i = 0;i < arrayStudentsSort.length; i++){
            arrayStudents[indexes[i]] = arrayStudentsSort[i];
        }

        StudentList sortedStudentList = new StudentArrayList();
        for (int i = 0;i < arrayStudents.length; i++){
            sortedStudentList.add(arrayStudents[i]);
        }
        return sortedStudentList;
    }
}
