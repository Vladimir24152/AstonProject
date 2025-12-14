package org.example.model;

public class Student {

    private String name;
    private String lastname;
    private Integer groupNumber;
    private Double averageScore;
    private Integer gradeBookNumber;
    private Integer age;
    private String address;

//    Реализация паттерна Builder через статический внутренний класс
    public static class Builder {
        private String name;
        private String lastname;
        private Integer groupNumber;
        private Double averageScore;
        private Integer gradeBookNumber; //был тип переменной String, название "creditCardNumber"
        private Integer age = 0;
        private String address = "address unknown";

        public Builder(String name, String lastname, Integer groupNumber, Double averageScore, Integer gradeBookNumber) {
            this.name = name;
            this.lastname = lastname;
            this.groupNumber = groupNumber;
            this.averageScore = averageScore;
            this.gradeBookNumber = gradeBookNumber;
        }

//        Методы build для необязательных полей
        public Builder buildAge(Integer age){
            this.age = age;
            return this;
        }

        public Builder buildAddress(String address){
            this.address = address;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    private Student(Builder builder){
        this.name =builder.name;
        this.lastname =builder.lastname;
        this.groupNumber =builder.groupNumber;
        this.averageScore =builder.averageScore;
        this.gradeBookNumber =builder.gradeBookNumber;
        this.age = builder.age;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", groupNumber=" + groupNumber +
                ", averageScore=" + averageScore +
                ", gradeBookNumber='" + gradeBookNumber + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
