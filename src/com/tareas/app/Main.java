package com.tareas.app;

import com.tareas.exceptions.TaskNotFoundException;
import com.tareas.model.task.StateTask;
import com.tareas.model.task.Task;
import com.tareas.model.task.TaskImpl;
import com.tareas.model.user.User;
import com.tareas.model.user.UserImpl;
import com.tareas.service.TaskAdministrator;

import java.util.List;

public class Main {
  static void main(String[] args) {
    User usuario1 = new UserImpl(1, "Matute", "matute@gmail.com");
    User usuario2 = new UserImpl(2, "patinetaKiller", "patinetakiller@gmail.com");
    User usuario3 = new UserImpl(3, "rubio", "rubio@gmail.com");

    System.out.println(usuario1);

    Task task1 = new TaskImpl(1, "limpiar", StateTask.PENDIENTE, 5 );
    Task task2 = new TaskImpl(2, "cocinar", StateTask.PENDIENTE, 10 );
    Task task3 = new TaskImpl(3, "Estudiar programación", StateTask.PENDIENTE, 20 );

    TaskAdministrator taskAdministrator = new TaskAdministrator();
    taskAdministrator.agregarTarea(task1);
    taskAdministrator.agregarTarea(task2);
    taskAdministrator.agregarTarea(task3);

    List<Task> tasks = taskAdministrator.listarTareasPorOrdenDePrioridad();

    tasks.forEach(task -> {
      System.out.print("Name: " + task.getTitle() + "\n" + "Priority: " + task.calcularPrioridad());
      System.out.println(" ");
    });

    try{
    taskAdministrator.obtenerTareaPorId(1).cambiarEstado(StateTask.EN_PROGRESO);
    Task task1EnProgreso = taskAdministrator.obtenerTareaPorId(1);
    System.out.println(task1EnProgreso.getTitle() + " " + task1EnProgreso.getState());

    taskAdministrator.obtenerTareaPorId(1).cambiarEstado(StateTask.FINALIZADA);
    Task task1Finalizada = taskAdministrator.obtenerTareaPorId(1);
    System.out.println(task1Finalizada.getTitle() + " " + task1Finalizada.getState());


    taskAdministrator.obtenerTareaPorId(2).cambiarEstado(StateTask.FINALIZADA);
    taskAdministrator.obtenerTareaPorId(3).cambiarEstado(StateTask.FINALIZADA);

    taskAdministrator.listarTareasPorEstado(StateTask.FINALIZADA).forEach(task -> {
      System.out.println(task.getTitle() + " " + task.getState());
    });

    taskAdministrator.obtenerTareaPorId(54);

    }catch(TaskNotFoundException e){
      System.out.println(e.getMessage());
    }
  }
}
