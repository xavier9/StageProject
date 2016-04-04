package com.example.xavier.stageproject.Classes;

/**
 * Created by xavier on 22/02/2016.
 */
public class Message {
    /**
     * The Id.
     */
    int ID, /**
     * The Screen.
     */
    screen;
    /**
     * The Visible.
     */
    boolean visible;
    /**
     * The Title.
     */
    String title, /**
     * The Message.
     */
    message, /**
     * The Expiredate.
     */
    expiredate;

    /**
     * Instantiates a new Message.
     */
    public Message() {
    }

    /**
     * Instantiates a new Message.
     *
     * @param ID         the id
     * @param screen     the screen
     * @param visible    the visible
     * @param title      the title
     * @param message    the message
     * @param expiredate the expiredate
     */
    public Message(int ID, int screen, boolean visible, String title, String message, String expiredate) {
        this.ID = ID;
        this.screen = screen;
        this.visible = visible;
        this.title = title;
        this.message = message;
        this.expiredate = expiredate;
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
     * Gets screen.
     *
     * @return the screen
     */
    public int getScreen() {
        return screen;
    }

    /**
     * Sets screen.
     *
     * @param screen the screen
     */
    public void setScreen(int screen) {
        this.screen = screen;
    }

    /**
     * Gets visible.
     *
     * @return the visible
     */
    public boolean getVisible() {
        return visible;
    }

    /**
     * Sets visible.
     *
     * @param visible the visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
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
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets expiredate.
     *
     * @return the expiredate
     */
    public String getExpiredate() {
        return expiredate;
    }

    /**
     * Sets expiredate.
     *
     * @param expiredate the expiredate
     */
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
