import enams.Type;
import exception.TaskNotFoundException;
import task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MonthlyTasck monthlyTasck = new MonthlyTasck(
                "Название", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение");
        DailyTasck dailyTasck = new DailyTasck(
                "Название", Type.WORCK, LocalDateTime.of(2023,02,25,10,00), "Сообщение");
        OneTimeTask oneTimeTask = new OneTimeTask(
                "Название", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение");
        WeeklyTasck weeklyTasck = new WeeklyTasck(
                "Название", Type.WORCK, LocalDateTime.of(2023,02,15,10,00), "Сообщение");
        YearlyTask yearlyTask = new YearlyTask(
                "Название", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение");

        TaskService taskService = new TaskService();
        taskService.add(monthlyTasck);
        taskService.add(dailyTasck);
        taskService.add(oneTimeTask);
        taskService.add(weeklyTasck);
        taskService.add(yearlyTask);

        System.out.println(taskService);

        try {
            System.out.println(taskService.remove(3));
        } catch (TaskNotFoundException e) {
            System.out.println("Нет такой задачи");
        }

        System.out.println(taskService.getAllByDate(LocalDate.of(2023,1,25)));
        System.out.println(taskService.get);











    }
}