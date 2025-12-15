package com.tareas.service;

import com.tareas.exceptions.TaskNotFoundException;
import com.tareas.helper.SortByPriority;
import com.tareas.model.task.StateTask;
import com.tareas.model.task.Task;

import java.util.*;

public class TaskAdministrator {
  private Map<Integer, Task> taskCatalogo;

  public TaskAdministrator(){
    this.taskCatalogo = new HashMap<>();
  }

  public void agregarTarea(Task task){
    int taskId = task.getId();
    this.taskCatalogo.put(taskId, task);
  }

  public Task obtenerTareaPorId(int taskId){
    Task task = this.taskCatalogo.get(taskId);
    if(task == null) throw new TaskNotFoundException("Tarea no encontrada.");
    return task;
  }

  public void completarTarea(int taskId){
    Task task = this.obtenerTareaPorId(taskId);
    task.cambiarEstado(StateTask.FINALIZADA);
  }

  public List<Task> listarTareasPorEstado(StateTask state){
    List<Task> tasks = new ArrayList<>();

    for(int key : this.taskCatalogo.keySet()){
      Task task = this.taskCatalogo.get(key);
      if(task.getState() == state)
        tasks.add(task);
    }
    return tasks;
  }

  public List<Task> listarTareasPorOrdenDePrioridad(){
    List<Task> tasksList = new ArrayList<>();

    for(int key: this.taskCatalogo.keySet()) {
      tasksList.add(this.taskCatalogo.get(key));
    }

    Collections.sort(tasksList, new SortByPriority());

    return  tasksList;
  }
}
