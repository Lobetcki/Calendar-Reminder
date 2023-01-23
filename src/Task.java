import enams.Repeatability;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public abstract class Task {


    private int id;
    private String title ;
    private String field;
    private Repeatability repeatability;
    private Date dateCreated = new Date();

    private Tupe tupe;
    public enum Tupe { PERSONAL, WORCK; }

    LocalDateTime time;
    public Task(String title, String field, Repeatability repeatability, Tupe tupe) {
        id = id++;
        this.title = title;
        this.field = field;
        this.repeatability = repeatability;
        this.tupe = tupe;
        Date dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Tupe getTupe() {
        return tupe;
    }

    public void setTupe(Tupe tupe) {
        this.tupe = tupe;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(field, task.field) && repeatability == task.repeatability && Objects.equals(dateCreated, task.dateCreated) && tupe == task.tupe && Objects.equals(time, task.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, field, repeatability, dateCreated, tupe, time);
    }
}


