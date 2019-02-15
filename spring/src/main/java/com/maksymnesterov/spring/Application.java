package com.maksymnesterov.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private Printer printer;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        Application app = context.getBean(Application.class);
        app.printer.print();
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
