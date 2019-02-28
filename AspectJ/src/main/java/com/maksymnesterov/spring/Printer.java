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

    public void print2() {
        System.out.println("\nPrint 2 method called!!!");
    }
}
