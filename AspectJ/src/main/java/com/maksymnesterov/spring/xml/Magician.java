package com.maksymnesterov.spring.xml;


import java.util.Random;

public class Magician implements MindReader {

    private String thoughts;

    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteers's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public void getThoughts() throws Exception {
        if (new Random().nextBoolean()) {
            System.out.printf("Magician is feeling it... \"%s\"", thoughts);
        } else {
            System.out.println("The magician was wrong");
            throw new Exception();
        }
    }
}
