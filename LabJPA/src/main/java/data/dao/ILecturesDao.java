package data.dao;

import data.model.Lecture;

public interface ILecturesDao {

    Lecture addLecture(Lecture lecture);

    Lecture getLecture(int id);

    void saveLecture(Lecture lecture);

}