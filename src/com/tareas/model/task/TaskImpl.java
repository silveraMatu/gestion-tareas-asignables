package com.tareas.model.task;

public class TaskImpl extends Task {

  private int complejidadEstimada;

  public TaskImpl(int id, String title, String description, StateTask state, int complejidadEstimada){
    super(id, title, description, state);
    this.complejidadEstimada = complejidadEstimada;
  }

  @Override
  public int calcularPrioridad() {
    return this.complejidadEstimada * 2;
  }
}
