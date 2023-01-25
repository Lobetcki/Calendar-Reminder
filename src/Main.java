import enams.Type;
import exception.TaskNotFoundException;
import task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MonthlyTasck monthlyTasck = new MonthlyTasck(
                "monthlyTasck", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение");
        DailyTasck dailyTasck = new DailyTasck(
                "dailyTasck", Type.WORCK, LocalDateTime.of(2023,02,25,10,00), "Сообщение");
        OneTimeTask oneTimeTask = new OneTimeTask(
                "oneTimeTask", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение");
        WeeklyTasck weeklyTasck = new WeeklyTasck(
                "weeklyTasck", Type.WORCK, LocalDateTime.of(2023,02,15,10,00), "Сообщение");
        YearlyTask yearlyTask = new YearlyTask(
                "yearlyTask", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение");

        TaskService taskService = new TaskService();
        taskService.add(monthlyTasck);
        taskService.add(dailyTasck);
        taskService.add(oneTimeTask);
        taskService.add(weeklyTasck);
        taskService.add(yearlyTask);

        //System.out.println(taskService);


        try {
            System.out.println(taskService.remove(56));
        } catch (TaskNotFoundException e) {
            System.out.println("Нет такой задачи");
        }

        System.out.println("=================================");
        System.out.println(taskService.getAllByDate(LocalDate.of(2023,1,25)));
        System.out.println(taskService);











    }
}