package com.maxnesterov.labdb.model;

public class Student {
    private int id;
    private String pib;
    private int course;

    public Student(int id, String pib, int course) {
        this.id = id;
        this.pib = pib;
        this.course = course;
    }

    public Student(String pib, int course) {
        this.pib = pib;
        this.course = course;
    }

    public int getCourse() {
        return course;
    }
    public String getPib() {
        return pib;
    }

    public int getId() {
        return id;
    }
}