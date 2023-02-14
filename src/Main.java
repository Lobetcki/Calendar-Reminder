import enams.Type;
import exception.TaskNotFoundException;
import task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MonthlyTasck monthlyTasck = new MonthlyTasck("monthlyTasck", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение1");
        MonthlyTasck monthlyTasck1 = new MonthlyTasck("monthlyTasck", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение12");
        DailyTasck dailyTasck = new DailyTasck("dailyTasck", Type.WORCK, LocalDateTime.of(2023,02,25,10,00), "Сообщение2");
        DailyTasck dailyTasck1 = new DailyTasck("dailyTasck", Type.WORCK, LocalDateTime.of(2023,02,25,10,00), "Сообщение23");
        OneTimeTask oneTimeTask = new OneTimeTask("oneTimeTask", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение3");
        OneTimeTask oneTimeTask1 = new OneTimeTask("oneTimeTask", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение34");
        WeeklyTasck weeklyTasck = new WeeklyTasck("weeklyTasck", Type.WORCK, LocalDateTime.of(2023,02,25,10,00), "Сообщение4");
        WeeklyTasck weeklyTasck1 = new WeeklyTasck("weeklyTasck", Type.WORCK, LocalDateTime.of(2023,02,25,10,00), "Сообщение45");
        YearlyTask yearlyTask = new YearlyTask("yearlyTask", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение5");
        YearlyTask yearlyTask1 = new YearlyTask("yearlyTask", Type.PERSONAL, LocalDateTime.of(2023,01,25,10,00), "Сообщение56");

        TaskService taskService = new TaskService();
        taskService.add(monthlyTasck);
        taskService.add(monthlyTasck1);
        taskService.add(dailyTasck);
        taskService.add(dailyTasck1);
        taskService.add(oneTimeTask);
        taskService.add(oneTimeTask1);
        taskService.add(weeklyTasck);
        taskService.add(weeklyTasck1);
        taskService.add(yearlyTask);
        taskService.add(yearlyTask1);

        System.out.println(taskService);
        System.out.println("_________________________________________");

        try {
            System.out.println(taskService.updateTitle(2, "Изменили наименование"));
            System.out.println(taskService.updateDescription(2, "Изменили сообщение"));
//            System.out.println("Удалена задача - " + taskService.remove(2));
//            System.out.println("Удалена задача - " + taskService.remove(3));

        } catch (TaskNotFoundException e) {
            System.out.println("Нет такой задачи");
        }
        System.out.println("Удаленные задачи:");
        System.out.println(taskService.getRemovedTasks());
        System.out.println("=================================");
        System.out.println(taskService.getAllByDate(LocalDate.of(2025,1,28)));
        System.out.println("-------------------------------------");

        System.out.println(yearlyTask.appearsln(LocalDate.of(2024,1,28)));

        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println(taskService.getAllGroupeByDate());


    }
}