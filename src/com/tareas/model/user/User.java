package com.tareas.model.user;

public abstract class User {
  final int id;
  String name;
  String email;

  public User(int id, String name, String email){
    this.id = id;
    this.name = name;
    this.email = email;
  }

  //Al momento de imprimir en consola el objeto user debería
  //representarse como "name (email)"
  @Override
  public String toString(){
    return String.format("%s (%s)", this.getName(), this.getEmail());
  }

  //getters
  public int getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getEmail(){
    return this.email;
  }

  //setters

  public void setName(String newName){
      this.name = newName;
  }

  public void setEmail(String newEmail){
    this.email = newEmail;
  }
}
