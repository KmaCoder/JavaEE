import data.model.Lecture;
import data.model.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import workers.LecturesWorker;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        LecturesWorker worker = (LecturesWorker) context.getBean("worker");

        addData(worker);
    }

    private static void addData(LecturesWorker worker) {

        Lecture lecture1 = new Lecture("Lecture 1", 2.5,
                new Teacher("Andrii", "Glybovets", "+38011111111",
                        new Date(1970, 1, 1)));

        Lecture lecture2 = new Lecture("Lecture 2", 3.5,
                new Teacher("Mykola", "Glybovets", "+38022222222",
                        new Date(1971, 1, 1)));

        Lecture lecture3 = new Lecture("Lecture 3", 3.5,
                new Teacher("Teacccher3", "LastName", "+38033333333",
                        new Date(1972, 1, 1)));

        worker.addLecture(lecture1);
        worker.addLecture(lecture2);
        worker.addLecture(lecture3);
    }
}