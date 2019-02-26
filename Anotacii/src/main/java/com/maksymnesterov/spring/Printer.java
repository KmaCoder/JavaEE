package com.maksymnesterov.spring;

import java.util.List;

public class Printer {
    private List<String> someList;
    private int digit;
    private String someString;

    public Printer(List<String> someList, int digit, String someString) {
        this.someList = someList;
        this.digit = digit;
        this.someString = someString;
    }

    public void print() {
        System.out.println("Some list: ");
        someList.forEach(System.out::println);
        System.out.print("Some digit: ");
        System.out.println(digit);
        System.out.print("Some string: ");
        System.out.println(someString);
    }

    public List<String> getSomeList() {
        return someList;
    }

    public void setSomeList(List<String> someList) {
        this.someList = someList;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }
}
