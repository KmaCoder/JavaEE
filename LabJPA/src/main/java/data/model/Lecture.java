package data.model;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Lectures")
public class Lecture {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "credits")
    private double credits;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_fk")
    private Teacher teacher_fk;

    public Lecture() {
    }

    public Lecture(String name, double credits, Teacher teacher_fk) {
        this.name = name;
        this.credits = credits;
        this.teacher_fk = teacher_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getCredits() {
        return credits;
    }

    public Teacher getTeacher_fk() {
        return teacher_fk;
    }

    public void setTeacher_fk(Teacher teacher_fk) {
        this.teacher_fk = teacher_fk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return id == lecture.id &&
                Double.compare(lecture.credits, credits) == 0 &&
                Objects.equals(name, lecture.name) &&
                Objects.equals(teacher_fk, lecture.teacher_fk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, credits, teacher_fk);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", teacher_fk=" + teacher_fk +
                '}';
    }
}