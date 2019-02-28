package com.maksymnesterov.spring.xml;


public interface MindReader {
    void interceptThoughts(String thoughts);
    void getThoughts() throws Exception;
}