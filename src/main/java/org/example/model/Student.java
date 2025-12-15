package org.example.model;

import org.example.exceptions.IllegalStudentException;

public class Student implements Comparable<Student>{

    private String name;
    private String lastname;
    private Integer groupNumber;
    private Double averageScore;
    private String gradeBookNumber;
    private Integer age;
    private String address;

    //    Реализация паттерна Builder через статический внутренний класс
    public static class Builder {
        private String name;
        private String lastname;
        private Integer groupNumber;
        private Double averageScore;
        private String gradeBookNumber;
        private Integer age = 0;
        private String address = "address unknown";

        public Builder(String name, String lastname, Integer groupNumber, Double averageScore, String gradeBookNumber)
                throws IllegalStudentException {

            if (name.length() < 2)
                throw new IllegalStudentException("Имя должно быть не менее 2 символов");
            this.name = name;

            if (lastname.length() < 2)
                throw new IllegalStudentException("Фамилия должна быть не менее 2 символов");
            this.lastname = lastname;

            if (groupNumber <= 0)
                throw new IllegalStudentException("Номер группы должен быть больше нуля");
            this.groupNumber = groupNumber;

            if (averageScore < 2 || averageScore > 5)
                throw new IllegalStudentException("Средний бал должен быть в диапазоне от 2 до 5 включительно");
            this.averageScore = averageScore;

            if (gradeBookNumber.length() != 7)
                throw new IllegalStudentException("Номер зачетки должен составлять 7 символов");
            this.gradeBookNumber = gradeBookNumber;
        }

//        Методы build для необязательных полей
        public Builder buildAge(Integer age) throws IllegalStudentException {
            if (age < 0)
                throw new IllegalStudentException("Возраст должен быть как минимум больше нуля");
            this.age = age;

            return this;
        }

        public Builder buildAddress(String address) throws IllegalStudentException {
            if (address.length() > 255)
                throw new IllegalStudentException("Адрес не должен превышать 255 символов");
            this.address = address;

            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    private Student(Builder builder){
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.groupNumber = builder.groupNumber;
        this.averageScore = builder.averageScore;
        this.gradeBookNumber = builder.gradeBookNumber;
        this.age = builder.age;
        this.address = builder.address;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return  name + '|' +
                lastname + '|' +
                groupNumber + '|' +
                averageScore + '|' +
                gradeBookNumber + '|' +
                age + '|' +
                address + ';';
    }

    @Override
    public int compareTo(Student o) {
        if (this.groupNumber > o.groupNumber){
            return 1;
        }else if (this.groupNumber < o.groupNumber){
            return -1;
        }else {
            if (this.averageScore > o.averageScore){
                return 1;
            }else if (this.averageScore < o.averageScore){
                return -1;
            }else {
                return this.gradeBookNumber.compareTo(o.gradeBookNumber);
            }
        }
    }
}
