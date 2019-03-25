package main.mvc.dao;

import main.mvc.entities.Student;

import java.util.List;

public interface IStudentsDao {

    Student addStudent(Student student);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
    Student getStudentByPIB(String pib);
    List<Student> getAllStudentsByCourse(int course);
    void saveStudent(Student student);

}
