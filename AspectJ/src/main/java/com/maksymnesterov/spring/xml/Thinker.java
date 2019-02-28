package com.maksymnesterov.spring.xml;

public interface Thinker {
    public void thinkOfSomething(String thoughts);
    public String getThoughts();
    default void denyThoughts() {
        System.out.println("The interception was wrong...");
    }
}