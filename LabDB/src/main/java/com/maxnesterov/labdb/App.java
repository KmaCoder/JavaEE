package com.maxnesterov.labdb;

import com.maxnesterov.labdb.model.Student;
import com.maxnesterov.labdb.workers.WorkWithStudent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
    public static void main( String[] args ){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        WorkWithStudent worker =
                (WorkWithStudent) context.getBean("worker");
//new WorkWithStudents();
        Student testStudent = new Student("Vlad Valt", 5);
        worker.saveStudentToDb(testStudent);
    }
}
