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

    public TaskService() {
        this.taskMap = new HashMap<>();
        this.removedTasks = new ArrayList<>();
    }

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

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

    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskMap.values().stream().filter(e ->e.appearsln(localDate)).collect(Collectors.toList());
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
                '}';
    }
}
