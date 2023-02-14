package task;

import enams.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTasck extends Task{


    public DailyTasck(String title, Type tupe, LocalDateTime dateTimeate, String description) {
        super(title, tupe, dateTimeate, description);
    }

    @Override
    public boolean appearsln(LocalDate localDate) {
        return localDate.isAfter(getDateTimeate().toLocalDate()) || localDate.isEqual(getDateTimeate().toLocalDate());

    }

}
