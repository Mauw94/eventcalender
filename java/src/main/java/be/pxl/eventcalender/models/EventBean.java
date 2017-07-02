package be.pxl.eventcalender.models;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Maurits on 29-6-2017.
 */
public class EventBean {

    private int Id;
    private String subject;
    private String description;
    private String note;
    private Date date;
    private Time time;

    public EventBean(int id, String subject, String description, String note, Date date, Time time) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}


