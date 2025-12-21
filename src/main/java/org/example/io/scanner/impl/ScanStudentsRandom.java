package org.example.io.scanner.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentArrayListCollector;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.scanner.ScanStudents;
import org.example.model.Student;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScanStudentsRandom implements ScanStudents {

    private static final String[] names = new String[]{"Alexey", "Ivan", "Olga", "Evgeny", "Yulia", "Nikolay", "Yury", "Anna", "Anton", "Dmitry"};
    private static final String[] lastNames = new String[]{"Vorobyev", "Smirnov", "Sokolova", "Tumanov", "Alexeeva", "Petrov", "Frolov", "Kozlova", "Koshkin", "Dmitriev"};
    private static final String[] city = new String[]{"Moscow, ", "Saratov, ", "Perm, ", "Tumen, ", "Kursk, ", "Ekaterinburg, ", "Tver, ", "Volgograd, ", "Samara, ", "Tambov, "};
    private static final String[] street = new String[]{"Paveletskaya, ", "Smolenskaya, ", "Petrovskaya, ", "Moskowskaya, ", "Orekhovskaya, ", "Zelenaya, ", "Yagodnaya, ", "Futbolnaya, "};

    @Override
    public StudentList scanStudents(Integer count) {
        return Stream.generate(this::generateRandomStudent).limit(count).collect(new StudentArrayListCollector());
    }

    private Student generateRandomStudent() {
        Random random;
        try {
            random = new Random();
            return new Student.Builder(
                    names[random.nextInt(names.length -1)],
                    lastNames[random.nextInt(lastNames.length -1)],
                    random.nextInt(100, 600),
                    Math.round((2.0 + 3.0 * random.nextDouble()) * 100.0) / 100.0,
                    String.valueOf(random.nextInt(1_000_000, 10_000_000)))
                    .buildAge(random.nextInt(16, 100 +1))
                    .buildAddress(city[random.nextInt(city.length -1)]
                            + street[random.nextInt(street.length -1)]
                            + random.nextInt(200) + ", "
                            + random.nextInt(500) + ";")
                    .build();
        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        }
    }
}