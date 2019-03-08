package com.maxnesterov.labdb.dao;

import com.maxnesterov.labdb.model.Teacher;

public interface ITeacherDao {
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(int id);
    void saveTacher(Teacher teacher);
}