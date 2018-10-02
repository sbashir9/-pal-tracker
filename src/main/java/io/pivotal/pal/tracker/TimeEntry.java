package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
    private long id;

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TimeEntry() {

    }


    @Override
    public String toString() {
        return "TimeEntry{" +
                "projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                id == timeEntry.id &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId, date, hours, id);
    }
}
