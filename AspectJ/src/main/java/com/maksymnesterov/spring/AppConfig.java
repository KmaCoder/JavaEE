package com.maksymnesterov.spring;

import com.maksymnesterov.spring.annotations.PerformerKURACH;
import com.maksymnesterov.spring.annotations.PerformerNEKURACH;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.maksymnesterov.spring.annotations")
public class AppConfig {

    @Bean
    public PerformerNEKURACH normPerformer() {
        return new PerformerNEKURACH();
    }

    @Bean public PerformerKURACH neNormPerformer() {
        return new PerformerKURACH();
    }
}