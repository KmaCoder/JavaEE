package data.model;
import javax.persistence.*;

@Entity
@Table(name = "Lectures")
public class Lecture {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    private String name;
    private double credits;

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
//Getters and settings
}