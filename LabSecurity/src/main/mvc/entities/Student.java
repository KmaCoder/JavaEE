package main.mvc.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="students")
@NamedQueries({
        @NamedQuery(name = Student.getAllStudents, query = "SELECT student FROM Student student"),
        @NamedQuery(name =Student.getStudentByPib, query = "SELECT student FROM Student student WHERE student.pib = :pib"),
        @NamedQuery(name =Student.getStudentsByCourse, query = "SELECT student FROM Student student WHERE student.course = :course")
})
public class Student implements Serializable {
    public static final String getAllStudents = "Student.getAllStudents";
    public static final String getStudentByPib = "Student.getStudentByPib";
    public static final String getStudentsByCourse = "Student.getStudentsByCourse";
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int studentId;

    private String pib;
    private int course;
//getters, setters, equals, hash
}
