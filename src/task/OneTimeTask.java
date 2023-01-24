package task;

import enams.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{


    public OneTimeTask(String title, Type tupe, LocalDateTime dateTimeate, String description) {
        super(title, tupe, dateTimeate, description);
    }

    @Override
    public boolean appearsln(LocalDate localDate) {
        return localDate.isEqual(getDateTimeate().toLocalDate());
    }
}
