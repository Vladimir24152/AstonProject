package org.example.sorter;

import org.example.collection.StudentList;

public class StudentSorter {

    private SortStudents sortStudents;

    public StudentSorter(SortStudents sortStudents) {
        this.sortStudents = sortStudents;
    }

    public StudentList sortStudents(StudentList studentList) {
        return sortStudents.sortStudents(studentList);
    }
}
