package com.maxnesterov.labdb;

import com.maxnesterov.labdb.model.Student;
import com.maxnesterov.labdb.model.Teacher;
import com.maxnesterov.labdb.workers.WorkWithStudent;
import com.maxnesterov.labdb.workers.WorkWithTeacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class App{
    public static void main( String[] args ){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        WorkWithStudent worker =
                (WorkWithStudent) context.getBean("worker");
        Student testStudent = new Student("Max Nest", 3);
        worker.saveStudentToDb(testStudent);

        WorkWithTeacher workWithTeacher =
                (WorkWithTeacher) context.getBean("teachersWorker");
        Teacher teacher = new Teacher("Andrii", "Glybovets", new Date(), "+380675097865");
        teacher = workWithTeacher.addTeacher(teacher);
        teacher.setCellphone("+380123456789");
        workWithTeacher.saveTacher(teacher);
    }
}
