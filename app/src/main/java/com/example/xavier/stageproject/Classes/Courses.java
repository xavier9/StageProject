package com.example.xavier.stageproject.Classes;

import java.io.Serializable;

/**
 * Created by xavier on 26/02/2016.
 */
public class Courses implements Serializable {
    int Student_id, dag, period;
    String room, description, first_name, laste_name;

    public Courses() {
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLaste_name() {
        return laste_name;
    }

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
