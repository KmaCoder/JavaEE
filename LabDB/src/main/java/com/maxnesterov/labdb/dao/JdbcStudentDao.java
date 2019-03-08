package com.maxnesterov.labdb.dao;

import com.maxnesterov.labdb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcStudentDao implements IStudentDao{

    private static final String SQL_INSERT_STUDENT = "insert into students (pib,course) values (?,?)";

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_INSERT_STUDENT,
                student.getPib(),
                student.getCourse());
    }
}