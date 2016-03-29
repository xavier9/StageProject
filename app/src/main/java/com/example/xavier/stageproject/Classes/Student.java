package com.example.xavier.stageproject.Classes;

import java.util.Date;

/**
 * Created by xavier on 23/02/2016.
 */
public class Student {
    int ID;
    String lastname, firstname, klass, newe, repeating, swals, nationality, exitstudent, sex;
    Date dateofbirth;


    public Student() {
    }

    public Student(int ID, String lastname, String firstname, String klass, String newe, String repeating, String swals, String nationality, String exitstudent, String sex, Date dateofbirth) {
        this.ID = ID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.klass = klass;
        this.newe = newe;
        this.repeating = repeating;
        this.swals = swals;
        this.nationality = nationality;
        this.exitstudent = exitstudent;
        this.sex = sex;
        this.dateofbirth = dateofbirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getNewe() {
        return newe;
    }

    public void setNewe(String newe) {
        this.newe = newe;
    }

    public String getRepeating() {
        return repeating;
    }

    public void setRepeating(String repeating) {
        this.repeating = repeating;
    }

    public String getSwals() {
        return swals;
    }

    public void setSwals(String swals) {
        this.swals = swals;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getExitstudent() {
        return exitstudent;
    }

    public void setExitstudent(String exitstudent) {
        this.exitstudent = exitstudent;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
