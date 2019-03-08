package com.maxnesterov.labdb.workers;

import com.maxnesterov.labdb.dao.ITeacherDao;
import com.maxnesterov.labdb.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class WorkWithTeacher {
    @Autowired
    private ITeacherDao teachersDao;

    public Teacher addTeacher(Teacher teacher) {
        teachersDao.addTeacher(teacher);
        System.out.println("Teacher has been added " + teacher);
        return teacher;
    }

    public Teacher getTeacherById(int id) {
        return teachersDao.getTeacherById(id);
    }

    public void saveTacher(Teacher teacher) {
        teachersDao.saveTacher(teacher);
        System.out.println("Teacher has been saved " + teacher);
    }
}
