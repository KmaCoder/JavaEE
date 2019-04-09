package app.jdbcJPA.worker;

import app.jdbcJPA.data.dao.StudentDAO;
import app.jdbcJPA.data.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentWorker {

    @Autowired
    private StudentDAO studentService;

    public void addStudents(List<Student> students) {
        students.forEach(studentService::addStudent);
    }

    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    public List<Student> getStudentsByName(String name) {
        return studentService.getStudentsByName(name);
    }

    public void saveStudent(Student student) {
        try {
            studentService.saveStudent(student);
            System.out.println("Student saved");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
