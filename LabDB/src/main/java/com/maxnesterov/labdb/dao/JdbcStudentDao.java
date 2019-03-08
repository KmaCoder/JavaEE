package com.maxnesterov.labdb.dao;

import com.maxnesterov.labdb.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcStudentDao implements IStudentDao {

    private static final String SQL_INSERT_STUDENT = "insert into students (pib,course) values (?,?)";
    private static final String SQL_SELECT_STUDENT_BY_ID = "select id, pib, course from students where id = ?";

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public Student getStudentById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID,
                (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)), id);
    }

    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_INSERT_STUDENT, student.getPib(), student.getCourse());
    }
}