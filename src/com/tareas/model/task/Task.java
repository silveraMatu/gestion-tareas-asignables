package com.tareas.model.task;
import com.tareas.model.user.User;

public abstract class Task{
  private final int id;
  private String title;
  private String description;
  private StateTask state;
  private User asignedA;

  public Task(int id, String title, String description, StateTask state){
    this.id = id;
    this.title = title;
    this.description = description;
    this.state = state;
    this.asignedA = null;
  }

  public abstract int calcularPrioridad();

  //getters

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public StateTask getState() {
    return state;
  }

  public User getAsignedA() {
    return asignedA;
  }

  //setters
  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void cambiarEstado(StateTask newState){
    this.state = newState;
  }

  public void asignarUsuario(User user){
    this.asignedA = user;
  }
}