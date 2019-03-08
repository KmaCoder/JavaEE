package com.maxnesterov.labdb.workers;

import com.maxnesterov.labdb.dao.IStudentDao;
import com.maxnesterov.labdb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkWithStudent {
    @Autowired
    private IStudentDao studentsDao;

    public void saveStudentToDb(Student student){
        if ((student!=null)&&(student.getPib()!=null)&&(!"".equals(student.getPib()))&&(student.getCourse()>0)){
            studentsDao.addStudent(student);
            System.out.println("Student have been saved "+student);
        }
    }
}