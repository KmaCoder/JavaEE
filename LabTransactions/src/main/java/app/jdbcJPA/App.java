package app.jdbcJPA;

import app.jdbcJPA.data.dao.impl.StudentService;
import app.jdbcJPA.data.entities.Address;
import app.jdbcJPA.data.entities.Student;
import app.jdbcJPA.worker.StudentWorker;
import app.jdbcJPA.worker.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("db/jpa/SpringBeansJPA.xml");
//        Lecture lecture = new Lecture();
//        lecture.setName("Introduction to Spring");
//        lecture.setCredits(2.5);
//        WorkWithLecture worker = (WorkWithLecture) context.getBean("worker");
//        worker.addLecture(lecture);

        StudentWorker studentWorker = context.getBean(StudentWorker.class);
//        studentWorker.addStudents(App.generateStudents());

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet all students" + StudentService.ANSI_RESET);
        System.out.println(studentWorker.getAllStudents());

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name" + StudentService.ANSI_RESET);
        System.out.println(studentWorker.getStudentsByName("Leskiv"));

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich" + StudentService.ANSI_RESET);
        System.out.println(studentWorker.getStudentsByName("Nesterovich"));

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich again" + StudentService.ANSI_RESET);
        System.out.println(studentWorker.getStudentsByName("Nesterovich"));

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich again" + StudentService.ANSI_RESET);
        Student student = studentWorker.getStudentsByName("Nesterovich").get(0);
        System.out.println(student);
        student.setEmail("wrongemail");
        studentWorker.saveStudent(student);

        PropertyPlaceholderConfigurer values = context.getBean(PropertyPlaceholderConfigurer.class);
        System.out.println(values.getValues());

    }

    private static List<Student> generateStudents() {
        List<Student> students = new LinkedList<>();
        students.add(new Student("Kyrylo", "Kundik", "qqq@www.eee", new Date(1000000L), new Address("lya kakaya", "KYIV GEROI", "02068", "UA")));
        students.add(new Student("Kolya", "Mariel", "rrr@ttt.yyy", new Date(1500000L), new Address("lya kakaya street", "DRABIV GEROI", "1", "EU")));
        students.add(new Student("Max", "Nesterovich", "uuu@iii.ooo", new Date(2000000L), new Address("lya kakaya boulevard", "BELAYA CERKVA GEROI", "0", "UK")));
        students.add(new Student("Sashka", "Leskiv", "ppp@aaa.sss", new Date(2500000L), new Address("lya kakaya road", "KYIV GEROI", "01068", "UA")));
        return students;
    }

}
