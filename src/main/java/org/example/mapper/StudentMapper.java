package org.example.mapper;

import org.example.exceptions.IllegalStudentException;
import org.example.model.Student;

@FunctionalInterface
public interface StudentMapper {

    Student toStudent(String string) throws IllegalStudentException;
}
