package task;

import enams.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{


    public YearlyTask(String title, Type tupe, LocalDateTime dateTimeate, String description) {
        super(title, tupe, dateTimeate, description);
    }

    @Override
    public boolean appearsln(LocalDate localDate) {
        return localDate.equals(getDateTimeate().toLocalDate()) || localDate.getDayOfYear() == getDateTimeate().getDayOfYear()
                && localDate.isAfter(getDateTimeate().toLocalDate());

    }
}
