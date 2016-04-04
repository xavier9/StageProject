package com.example.xavier.stageproject.Classes;

/**
 * Created by xavier on 22/02/2016.
 */
public class Absence {
    /**
     * The Id.
     */
    int ID, /**
     * The Reason.
     */
    reason;
    /**
     * The Title.
     */
    String title, /**
     * The Name.
     */
    name, /**
     * The Hours.
     */
    hours, /**
     * The Date.
     */
    date, /**
     * The Note.
     */
    note;

    /**
     * Instantiates a new Absence.
     */
    public Absence() {
    }

    /**
     * Instantiates a new Absence.
     *
     * @param ID     the id
     * @param reason the reason
     * @param title  the title
     * @param name   the name
     * @param hours  the hours
     * @param date   the date
     * @param note   the note
     */
    public Absence(int ID, int reason, String title, String name, String hours, String date, String note) {
        this.ID = ID;
        this.reason = reason;
        this.title = title;
        this.name = name;
        this.hours = hours;
        this.date = date;
        this.note = note;
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
     * Gets reason.
     *
     * @return the reason
     */
    public int getReason() {
        return reason;
    }

    /**
     * Sets reason.
     *
     * @param reason the reason
     */
    public void setReason(int reason) {
        this.reason = reason;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets hours.
     *
     * @return the hours
     */
    public String getHours() {
        return hours;
    }

    /**
     * Sets hours.
     *
     * @param hours the hours
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets note.
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets note.
     *
     * @param note the note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return
                 name + "(" + hours + ")";
    }
}
