package task;

import exception.TaskNotFoundException;
import task.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    private  Map<Integer, Task> taskMap;
    private Collection<Task> removedTasks;

    public TaskService(Map<Integer, Task> taskMap, Collection<Task> removedTasks) {
        this.taskMap = taskMap;
        this.removedTasks = removedTasks;
    }

    public void add(Task task) {
        this.taskMap.put(task.getId(), task);
    }

    public Task remove (int id) throws TaskNotFoundException {
        Collections.addAll(removedTasks, taskMap.get(id));
        Task temp = taskMap.get(id);
        taskMap.remove(id);

        return temp;
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskMap.values().stream().filter(e ->e.appearsln(localDate)).collect(Collectors.toList());
    }



}
