package org.example.model;

public class Student {

    private String name;
    private String lastname;
    private Integer groupNumber;
    private Double averageScore;
    private String creditCardNumber;
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

        public Builder(String name, String lastname, Integer groupNumber, Double averageScore, String creditCardNumber) {
            this.name = name;
            this.lastname = lastname;
            this.groupNumber = groupNumber;
            this.averageScore = averageScore;
            this.gradeBookNumber = creditCardNumber;
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
        this.creditCardNumber =builder.gradeBookNumber;
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
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
