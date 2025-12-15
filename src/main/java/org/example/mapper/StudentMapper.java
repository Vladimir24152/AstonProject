package org.example.mapper;

import org.example.model.Student;

@FunctionalInterface
public interface StudentMapper {

    Student toStudent(String string);
}
