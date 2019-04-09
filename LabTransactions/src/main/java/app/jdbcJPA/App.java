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
        System.out.println(StudentService.ANSI_YELLOW + studentWorker.getAllStudents() + StudentService.ANSI_RESET);

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name" + StudentService.ANSI_RESET);
        System.out.println(StudentService.ANSI_YELLOW + studentWorker.getStudentsByName("Leskiv") + StudentService.ANSI_RESET);

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich" + StudentService.ANSI_RESET);
        System.out.println(StudentService.ANSI_YELLOW + studentWorker.getStudentsByName("Nesterovich") + StudentService.ANSI_RESET);

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich again" + StudentService.ANSI_RESET);
        System.out.println(StudentService.ANSI_YELLOW + studentWorker.getStudentsByName("Nesterovich") + StudentService.ANSI_RESET);

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich again and setting wrong email" + StudentService.ANSI_RESET);
        Student student = studentWorker.getStudentsByName("Nesterovich").get(0);
        System.out.println(StudentService.ANSI_YELLOW + student + StudentService.ANSI_RESET);
        student.setEmail("wrongemail");
        studentWorker.saveStudent(student);

        System.out.println(StudentService.ANSI_GREEN + "\n\nGet student by last name Nesterovich again, but setting correct email" + StudentService.ANSI_RESET);
        student = studentWorker.getStudentsByName("Nesterovich").get(0);
        System.out.println(StudentService.ANSI_YELLOW + student + StudentService.ANSI_RESET);
        student.setEmail("newemail@mail.com");
        studentWorker.saveStudent(student);

//        PropertyPlaceholderConfigurer values = context.getBean(PropertyPlaceholderConfigurer.class);
//        System.out.println(values.getValues());

    }

    private static List<Student> generateStudents() {
        List<Student> students = new LinkedList<>();
        students.add(new Student("Max", "Nesterovich", "uuu@iii.ooo", new Date(2000000L), new Address("lya kakaya boulevard", "BELAYA CERKVA GEROI", "UK")));
        students.add(new Student("Sashka", "Leskiv", "ppp@aaa.sss", new Date(2500000L), new Address("lya kakaya road", "KYIV GEROI", "UA")));
        students.add(new Student("Kyrylo", "Kundik", "qqq@www.eee", new Date(1000000L), new Address("lya kakaya", "KYIV GEROI", "UA")));
        students.add(new Student("Kolya", "Mariel", "rrr@ttt.yyy", new Date(1500000L), new Address("lya kakaya street", "DRABIV GEROI", "EU")));
        return students;
    }

}
