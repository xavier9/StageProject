package com.example.xavier.stageproject.Classes;

/**
 * Created by xavier on 22/02/2016.
 */
public class Absence {
    int ID, reason;
    String title, name, hours, date, note;

    public Absence() {
    }

    public Absence(int ID, int reason, String title, String name, String hours, String date, String note) {
        this.ID = ID;
        this.reason = reason;
        this.title = title;
        this.name = name;
        this.hours = hours;
        this.date = date;
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return
                 name + "(" + hours + ")";
    }
}
