package workers;

import data.dao.ILecturesDao;
import data.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;

public class LecturesWorker {
    @Autowired
    ILecturesDao lecturesDao;

    public Lecture addLecture(Lecture lecture) {
        lecture = lecturesDao.addLecture(lecture);
        System.out.println(lecture);
        return lecture;
    }
}