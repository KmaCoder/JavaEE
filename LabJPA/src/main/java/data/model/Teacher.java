package data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "teacherid")
    private int teacherid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "cell_phone")
    private String cell_phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date dateOfBirth;

    public Teacher() {

    }

    public Teacher(String firstname, String lastname, String cell_phone, Date dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.cell_phone = cell_phone;
        this.dateOfBirth = dateOfBirth;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCell_phone() {
        return cell_phone;
    }

    public void setCell_phone(String cell_phone) {
        this.cell_phone = cell_phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherid == teacher.teacherid &&
                Objects.equals(firstname, teacher.firstname) &&
                Objects.equals(lastname, teacher.lastname) &&
                Objects.equals(cell_phone, teacher.cell_phone) &&
                Objects.equals(dateOfBirth, teacher.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherid, firstname, lastname, cell_phone, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cell_phone='" + cell_phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}