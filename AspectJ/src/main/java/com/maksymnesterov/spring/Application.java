package com.maksymnesterov.spring;

import com.maksymnesterov.spring.annotations.IPerformer;
import com.maksymnesterov.spring.xml.Magician;
import com.maksymnesterov.spring.xml.Thinker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        new Application();
    }

    private Application() {
//        annotations();
        xml();
    }

    private void annotations() {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.register(AppConfig.class);
        annotationContext.refresh();

        IPerformer normPerformer = (IPerformer) annotationContext.getBean("normPerformer");
        IPerformer neNormPerformer = (IPerformer) annotationContext.getBean("neNormPerformer");
        try {
            normPerformer.perform();
            neNormPerformer.perform();
        } catch (Exception ignored) {
        }
    }

    private void xml() {
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("aspectJ.xml");
        Thinker volunteer = (Thinker) xmlContext.getBean("volunteer");
        Magician magician = (Magician) xmlContext.getBean("magician");
        volunteer.thinkOfSomething("Volunteer thinks...");
        try {
            magician.getThoughts();
        } catch (Exception ignored) {
        }
    }
}
