package task;

import enams.Repeatability;
import enams.Type;

import java.time.LocalDateTime;

public class DailyTasck extends Task{


    public DailyTasck(String title, Type tupe, LocalDateTime dateTimeate, String description) {
        super(title, tupe, dateTimeate, description);
    }

    @Override
    public boolean appearsln(LocalDateTime localDateTime) {
        return false;
    }
}
