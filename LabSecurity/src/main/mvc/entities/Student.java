package main.mvc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = Student.getAllStudents, query = "SELECT student FROM Student student"),
        @NamedQuery(name = Student.getStudentByPib, query = "SELECT student FROM Student student WHERE student.pib = :pib"),
        @NamedQuery(name = Student.getStudentsByCourse, query = "SELECT student FROM Student student WHERE student.course = :course")
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


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                course == student.course &&
                Objects.equals(pib, student.pib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, pib, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", pib='" + pib + '\'' +
                ", course=" + course +
                '}';
    }
}
