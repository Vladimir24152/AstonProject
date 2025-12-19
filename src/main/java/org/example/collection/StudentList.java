package org.example.collection;

import org.example.model.Student;

import java.util.stream.Stream;

public interface StudentList {

    void add(Student student);

    void clean();

    Student get(Integer index);

    Integer size();

    Stream<Student> stream();

    Integer contains(Integer groupNumber);
}
