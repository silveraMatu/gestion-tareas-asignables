package com.tareas.helper;

import com.tareas.model.task.Task;

import java.util.Comparator;

public class SortByPriority implements Comparator<Task> {
  @Override
  public int compare(Task task1, Task task2) {
    int priorityTask1 = task1.calcularPrioridad();
    int priorityTask2 = task2.calcularPrioridad();
    return priorityTask2 - priorityTask1;
  }
}
