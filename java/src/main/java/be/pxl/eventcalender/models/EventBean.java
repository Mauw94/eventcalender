package be.pxl.eventcalender.models;

import java.util.Date;

/**
 * Created by Maurits on 29-6-2017.
 */
public class EventBean {

    private int Id;
    private String subject;
    private String description;
    private String note;
    private Date dateTime;

    public EventBean(int id, String subject, String description, String note, Date dateTime) {
        Id = id;
        this.subject = subject;
        this.description = description;
        this.note = note;
        this.dateTime = dateTime;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}


