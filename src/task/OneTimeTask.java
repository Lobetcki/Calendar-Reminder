package task;

import enams.Type;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(int idGenerator, String title, Type tupe, String field, LocalDateTime dateTimeate, String description) {
        super(idGenerator, title, tupe, field, dateTimeate, description);
    }

    @Override
    public boolean appearsln(LocalDateTime localDateTime) {
        return false;
    }
}
