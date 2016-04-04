package com.example.xavier.stageproject.Classes;

import java.util.Date;

/**
 * Created by xavier on 23/02/2016.
 */
public class Student {
    /**
     * The Id.
     */
    int ID;
    /**
     * The Lastname.
     */
    String lastname, /**
     * The Firstname.
     */
    firstname, /**
     * The Klass.
     */
    klass, /**
     * The Newe.
     */
    newe, /**
     * The Repeating.
     */
    repeating, /**
     * The Swals.
     */
    swals, /**
     * The Nationality.
     */
    nationality, /**
     * The Exitstudent.
     */
    exitstudent, /**
     * The Sex.
     */
    sex;
    /**
     * The Dateofbirth.
     */
    Date dateofbirth;


    /**
     * Instantiates a new Student.
     */
    public Student() {
    }

    /**
     * Instantiates a new Student.
     *
     * @param ID          the id
     * @param lastname    the lastname
     * @param firstname   the firstname
     * @param klass       the klass
     * @param newe        the newe
     * @param repeating   the repeating
     * @param swals       the swals
     * @param nationality the nationality
     * @param exitstudent the exitstudent
     * @param sex         the sex
     * @param dateofbirth the dateofbirth
     */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets id.
     *
     * @param ID the id
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets klass.
     *
     * @return the klass
     */
    public String getKlass() {
        return klass;
    }

    /**
     * Sets klass.
     *
     * @param klass the klass
     */
    public void setKlass(String klass) {
        this.klass = klass;
    }

    /**
     * Gets newe.
     *
     * @return the newe
     */
    public String getNewe() {
        return newe;
    }

    /**
     * Sets newe.
     *
     * @param newe the newe
     */
    public void setNewe(String newe) {
        this.newe = newe;
    }

    /**
     * Gets repeating.
     *
     * @return the repeating
     */
    public String getRepeating() {
        return repeating;
    }

    /**
     * Sets repeating.
     *
     * @param repeating the repeating
     */
    public void setRepeating(String repeating) {
        this.repeating = repeating;
    }

    /**
     * Gets swals.
     *
     * @return the swals
     */
    public String getSwals() {
        return swals;
    }

    /**
     * Sets swals.
     *
     * @param swals the swals
     */
    public void setSwals(String swals) {
        this.swals = swals;
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets exitstudent.
     *
     * @return the exitstudent
     */
    public String getExitstudent() {
        return exitstudent;
    }

    /**
     * Sets exitstudent.
     *
     * @param exitstudent the exitstudent
     */
    public void setExitstudent(String exitstudent) {
        this.exitstudent = exitstudent;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets dateofbirth.
     *
     * @return the dateofbirth
     */
    public Date getDateofbirth() {
        return dateofbirth;
    }

    /**
     * Sets dateofbirth.
     *
     * @param dateofbirth the dateofbirth
     */
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
