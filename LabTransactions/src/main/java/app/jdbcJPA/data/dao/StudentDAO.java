package app.jdbcJPA.data.dao;

import app.jdbcJPA.data.entities.Student;
import app.jdbcJPA.exceptions.IllegalEmailException;

import java.util.List;

public interface StudentDAO {

    public Student addStudent(Student student);

    public Student getStudentById(Long id);

    public List<Student> getStudentsByName(String name);

    public List<Student> getStudents();

    public void saveStudent(Student student) throws IllegalEmailException;

}
