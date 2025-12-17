package org.example.io.scanner.impl;

import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.exceptions.IllegalStudentException;
import org.example.io.scanner.ScanStudents;
import org.example.model.Student;
import java.util.Random;

public class ScanStudentsRandom implements ScanStudents {

    private static final String[] names = new String[]{"Alexey", "Ivan", "Olga", "Evgeny", "Yulia", "Nikolay", "Yury", "Anna", "Anton", "Dmitry"};
    private static final String[] lastNames = new String[]{"Vorobyev", "Smirnov", "Sokolova", "Tumanov", "Alexeeva", "Petrov", "Frolov", "Kozlova", "Koshkin", "Dmitriev"};
    private static final String[] city = new String[]{"Moscow, ", "Saratov, ", "Perm, ", "Tumen, ", "Kursk, ", "Ekaterinburg, ", "Tver, ", "Volgograd, ", "Samara, ", "Tambov, "};
    private static final String[] street = new String[]{"Paveletskaya, ", "Smolenskaya, ", "Petrovskaya, ", "Moskowskaya, ", "Orekhovskaya, ", "Zelenaya, ", "Yagodnaya, ", "Futbolnaya, "};

    @Override
    public StudentList scanStudents(Integer count) {
        StudentList list;
        Random random;
        try {
            random = new Random();
            list = new StudentArrayList();
            for (int i = 0; i < count; i++ ){
                new StudentArrayList();
                Student student;
                student = new Student.Builder(
                        names[random.nextInt(names.length -1)], //имена
                        lastNames[random.nextInt(lastNames.length -1)], //фамилии
                        random.nextInt(100, 600), //номера групп
                        Math.round((2.0 + 3.0 * random.nextDouble()) * 100.0) / 100.0,//средний балл с округлением до 2 знаков после запятой
                        String.valueOf(random.nextInt(1_000_000, 10_000_000)))//номер зачетки
                        .buildAge(random.nextInt(16, 100 +1)) //возраст
                        .buildAddress(city[random.nextInt(city.length -1)] //города
                                + street[random.nextInt(street.length -1)] //улицы
                                + random.nextInt(200) + ", " //номер дома
                                + random.nextInt(500) + ";") //номер квартиры
                        .build();
                list.add(student);
            }
            return list;
        } catch (IllegalStudentException e) {
            throw new RuntimeException(e);
        }
    }
}