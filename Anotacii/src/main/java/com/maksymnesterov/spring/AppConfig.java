package com.maksymnesterov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Autowired
    private Printer printer;

    @Bean
    public Printer getPrinter() {
        return new Printer(Arrays.asList("A", "B", "C"), 99, "Qwerty");
    }

    @Bean
    public Application getApp() {
        return new Application(printer);
    }
}
