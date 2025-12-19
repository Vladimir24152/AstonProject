package org.example.collection;

import org.example.model.Student;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

public class StudentArrayList implements StudentList, Iterable<Student>{

    private Integer CAPACITY = 10;

    private Student[] students = new Student[CAPACITY];

    private Integer size = 0;

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
        size = 0;
    }

    @Override
    public Student get(Integer index) {
        return students[index];
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator();
    }

    @Override
    public Integer contains(Integer groupNumber, Integer countThread) {

        AtomicInteger result = new AtomicInteger(0);

        for (int i = 1; i <= countThread; i++) {
            Integer finalI = i;
            System.out.println("создали поток " + i);
            Thread thread = new Thread( ()-> {
                for (int j = (size / countThread * finalI) - (size / countThread * finalI - 1); j < (size / countThread * finalI) ; j++) {
                    if (students[j].getGroupNumber() == groupNumber) {
                        result.incrementAndGet();
                    }
                }
            });
            thread.start();
        }
        return result.get();
    }

    private class StudentIterator implements Iterator<Student> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Student next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return students[currentIndex++];
        }
    }

    @Override
    public void forEach(Consumer<? super Student> action) {
        for (Student student : this) {
            action.accept(student);
        }
    }

    @Override
    public Spliterator<Student> spliterator() {
        return Spliterators.spliterator(
                students,
                0,
                size,
                Spliterator.ORDERED | Spliterator.IMMUTABLE
        );
    }

    public java.util.stream.Stream<Student> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
