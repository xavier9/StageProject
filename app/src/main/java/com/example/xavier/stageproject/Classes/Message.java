package com.example.xavier.stageproject.Classes;

/**
 * Created by xavier on 22/02/2016.
 */
public class Message {
    int ID, screen;
    boolean visible;
    String title, message, expiredate;

    public Message() {
    }

    public Message(int ID, int screen, boolean visible, String title, String message, String expiredate) {
        this.ID = ID;
        this.screen = screen;
        this.visible = visible;
        this.title = title;
        this.message = message;
        this.expiredate = expiredate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ID=" + ID +
                ", screen=" + screen +
                ", visible=" + visible +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", expiredate='" + expiredate + '\'' +
                '}';
    }
}
