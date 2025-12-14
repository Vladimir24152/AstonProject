package org.example.io.scanner.impl;
import org.example.collection.StudentArrayList;
import org.example.collection.StudentList;
import org.example.io.scanner.ScanStudents;
import org.example.model.Student;
import java.util.Random;

public class ScanStudentsRandom implements ScanStudents {

    private static final String[] Names = new String[]{"Alexey", "Ivan", "Olga", "Evgeny", "Yulia", "Nikolay", "Yury", "Anna", "Anton", "Dmitry"};
    private static final String[] LastNames = new String[]{"Vorobyev", "Smirnov", "Sokolova", "Tumanov", "Alexeeva", "Petrov", "Frolov", "Kozlova", "Koshkin", "Dmitriev"};
    private static final Integer[] GroupNumber = new Integer[]{101, 105, 108, 130, 211, 213, 220, 226, 338, 340, 360, 361, 477, 478, 423, 442, 502, 506, 507, 510};
    private static final Double[] AverageScore = new Double[]{2.0, 2.3, 2.5, 2.8, 3.0, 3.3, 3.5, 3.8, 4.0, 4.3, 4.5, 4.8, 5.0};
    private static final Integer[] GradeBookNumber = new Integer[]{3334445, 7778844, 6645568, 9596949, 4477885, 2123454, 3121342, 5557556, 9959461, 7679481};
    private static final String[] Address = new String[]{"Moscow, Paveletskaya 48, 5", "Moskow, Smolenskaya 11, 13 ", "Moskow, Petrovskaya 20, 4", "Moskow, Liteynaya 16, 109"};
    private static final Integer[] Age = new Integer[]{16, 17, 18, 19, 20, 21, 22, 23};

    @Override
    public StudentList scanStudents(Integer count) {
        StudentList list = new StudentArrayList();
        Random random = new Random();
        for (int i = 0; i < count; i++ ){
            Student student = new Student.Builder(
                    Names[random.nextInt(Names.length -1)],
                    LastNames[random.nextInt(LastNames.length -1)],
                    GroupNumber[random.nextInt(GroupNumber.length -1)],
                    AverageScore[random.nextInt(AverageScore.length -1)],
                    GradeBookNumber[random.nextInt(GradeBookNumber.length -1)])
                    .buildAge(1) //Age[random.nextInt(Age.length -1)]) - изменяет конструктор в Builder класса Student
                    .buildAddress("")//Address[random.nextInt(Address.length -1)] - аналогично
                    .build();
            list.add(student);
        }
        return list;
    }
}
