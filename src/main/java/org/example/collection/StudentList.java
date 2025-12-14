package org.example.collection;

import org.example.model.Student;

public interface StudentList {

    void add(Student student);

    void clean();

    Student get(Integer index);

    int size();
}
