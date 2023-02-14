package task;

import enams.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTasck extends Task{


    public WeeklyTasck(String title, Type tupe, LocalDateTime dateTimeate, String description) {
        super(title, tupe, dateTimeate, description);
    }

    @Override
    public boolean appearsln(LocalDate localDate) {
        return localDate.isEqual(getDateTimeate().toLocalDate()) || localDate.getDayOfWeek() == getDateTimeate().getDayOfWeek()
                && localDate.isAfter(getDateTimeate().toLocalDate());
    }
}
