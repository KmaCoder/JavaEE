package com.maxnesterov.labdb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue
    private int teacherId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "cell_phone")
    private String cellphone;

    public Teacher(String firstname, String lastname, Date birthDate, String cellphone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.cellphone = cellphone;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}