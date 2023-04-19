package com.crud.model;

public class Student {
    private int studentId;
    private String studentName;
    private String studentAddress;
    private int studentAge;


    //constructor
    public Student(String studentName, int studentAge, String studentAddress) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentAge = studentAge;
    }

    public Student(int studentId, String studentName, int studentAge, String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentAge = studentAge;
    }
//getters and setters

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
