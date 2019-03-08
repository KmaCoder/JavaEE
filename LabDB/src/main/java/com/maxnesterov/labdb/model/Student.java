package com.maxnesterov.labdb.model;

public class Student {
    private String pib;
    private int course;

    public Student(String pib, int course) {
        this.pib = pib;
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }
}