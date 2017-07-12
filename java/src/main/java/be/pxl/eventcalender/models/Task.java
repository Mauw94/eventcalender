package be.pxl.eventcalender.models;

import java.io.Serializable;

public class Task implements Serializable{
    private int id;
    private String subject;
    private String description;
    private int duration;
    private int estimated;
    private boolean finished;

    public Task(int id, String subject, String description, int duration, int estimated, boolean finished) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.duration = duration;
        this.estimated = estimated;
        this.finished = finished;
    }

    public Task() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEstimated() {
        return estimated;
    }

    public void setEstimated(int estimated) {
        this.estimated = estimated;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
