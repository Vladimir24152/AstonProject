package org.example.collection;

import org.example.model.Student;

public class StudentArrayList implements StudentList{

    private Integer CAPACITY = 10;

    private Student[] students = new Student[CAPACITY];

    private Integer size;

    @Override
    public void add(Student student) {
        if (size == students.length){
            CAPACITY = CAPACITY * 2;
            Student[] newStudents = new Student[CAPACITY];
            for (int i = 0; i < students.length; i++){
                newStudents[i] = students[i];
            }
            students = newStudents;
        }
        students[size] = student;
        size++;
    }

    @Override
    public void clean() {
        students = new Student[10];
    }

    @Override
    public Student get(Integer index) {
        return students[index];
    }
}
