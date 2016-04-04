package com.example.xavier.stageproject.Classes;

import java.io.Serializable;

/**
 * Created by xavier on 26/02/2016.
 */
public class Courses implements Serializable {
    /**
     * The Student id.
     */
    int Student_id, /**
     * The Dag.
     */
    dag, /**
     * The Period.
     */
    period;
    /**
     * The Room.
     */
    String room, /**
     * The Description.
     */
    description, /**
     * The First name.
     */
    first_name, /**
     * The Laste name.
     */
    laste_name;

    /**
     * Instantiates a new Courses.
     */
    public Courses() {
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public int getStudent_id() {
        return Student_id;
    }

    /**
     * Sets student id.
     *
     * @param student_id the student id
     */
    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    /**
     * Gets dag.
     *
     * @return the dag
     */
    public int getDag() {
        return dag;
    }

    /**
     * Sets dag.
     *
     * @param dag the dag
     */
    public void setDag(int dag) {
        this.dag = dag;
    }

    /**
     * Gets period.
     *
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Sets period.
     *
     * @param period the period
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Sets first name.
     *
     * @param first_name the first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Gets laste name.
     *
     * @return the laste name
     */
    public String getLaste_name() {
        return laste_name;
    }

    /**
     * Sets laste name.
     *
     * @param laste_name the laste name
     */
    public void setLaste_name(String laste_name) {
        this.laste_name = laste_name;
    }

    @Override
    public String toString() {
        return
                room + " - "+ description
                         + "\n"
                         + laste_name ;
    }
}
