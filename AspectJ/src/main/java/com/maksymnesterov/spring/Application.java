package com.maksymnesterov.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private Printer printer;

    public Application(Printer printer) {
        this.printer = printer;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        Application app = context.getBean(Application.class);
        app.printer.print();

        Printer printer = context.getBean(Printer.class);
        printer.print2();
    }

}
