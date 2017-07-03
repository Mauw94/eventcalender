package be.pxl.eventcalender.models;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Maurits on 29-6-2017.
 */
public class EventBean {

    private int Id;
    private String subject;
    private String description;
    private String note;
    private String date;
    private String time;

    public EventBean(int id, String subject, String description, String note, String date, String time) {
        Id = id;
        this.subject = subject;
        this.description = description;
        this.note = note;
        this.date = date;
        this.time = time;
    }

    public EventBean() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


