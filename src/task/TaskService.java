package task;

import exception.TaskNotFoundException;

import task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TaskService {
                                                                        //  Поля
    private final Map<Integer, Task> taskMap;
    private final Collection<Task> removedTasks;
                                                                        // Конструктор
    public TaskService() {
        this.taskMap = new HashMap<>();
        this.removedTasks = new ArrayList<>();
    }
                                                                        // add(Task)
    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }
                                                                        //  updateTitle(int, String) замена названия
    public Task updateTitle(int id, String str) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            taskMap.get(id).setTitle(str);
            return taskMap.get(id);
        } else {
            throw new TaskNotFoundException();
        }
    }
                                                                        // updateDescription(int, String) замена содержания
    public Task updateDescription(int id, String str) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            taskMap.get(id).setDescription(str);
            return taskMap.get(id);
        } else {
            throw new TaskNotFoundException();
        }
    }
                                                                        //getRemovedTasks()
    public Collection<Task> getRemovedTasks() {
        return removedTasks;
    }
                                                                            // remove (int
    public Task remove (int id) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            Collections.addAll(removedTasks, taskMap.get(id));
            Task temp = taskMap.get(id);
            taskMap.remove(id);
            return temp;
        } else {
            throw new TaskNotFoundException();
        }

    }
                                                                            // getAllGroupeByDate
    public Map<LocalDate, List<Task>> getAllGroupeByDate() {

        Map<LocalDate, List<Task>> map2 = new HashMap<>();                              //map

        List<Task> list = new ArrayList<>(taskMap.values()).stream()
                .sorted(Comparator.comparing(Task::getDateTimeate)).collect(Collectors.toList()); //Сортировка list

                list.stream().map(t ->
                map2.put(
                        t.getDateTimeate().toLocalDate(),
                        list.stream().filter(task ->
                                        task.getDateTimeate().equals(t.getDateTimeate()))
                                .collect(Collectors.toList()))
        ).collect(Collectors.toSet());

        return map2;
    }



                                                                            //  getAllByDate(LocalDate
    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskMap.values().stream()
                .filter(e ->e.appearsln(localDate)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return taskMap.equals(that.taskMap) && removedTasks.equals(that.removedTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskMap, removedTasks);
    }

    @Override
    public String toString() {
        return "TaskService{" +
                "taskMap=" + taskMap +
                ", removedTasks=" + removedTasks +
                '}' + "\n";
    }
}
