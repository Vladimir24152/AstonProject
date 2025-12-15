package org.example.collection;

import org.example.model.Student;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StudentArrayListCollector implements Collector<Student, StudentArrayList, StudentArrayList> {
    @Override
    public Supplier<StudentArrayList> supplier() {
        return StudentArrayList::new;
    }

    @Override
    public BiConsumer<StudentArrayList, Student> accumulator() {
        return StudentArrayList::add;
    }

    @Override
    public BinaryOperator<StudentArrayList> combiner() {
        return null;
    }

    @Override
    public Function<StudentArrayList, StudentArrayList> finisher() {
        return students -> students;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
