package com.gl.HibernateProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacherid")
  private int id;
  private String first_Name;
  private String last_Name;
  @Column(nullable = false)
  private String email;
  public Teacher(){

  }

  public Teacher(int id, String first_Name, String last_Name, String email) {
    this.id = id;
    this.first_Name = first_Name;
    this.last_Name = last_Name;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirst_Name() {
    return first_Name;
  }

  public void setFirst_Name(String first_Name) {
    this.first_Name = first_Name;
  }

  public String getLast_Name() {
    return last_Name;
  }

  public void setLast_Name(String last_Name) {
    last_Name = last_Name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Teacher{" +
      "id=" + id +
      ", first_Name='" + first_Name + '\'' +
      ", Last_Name='" + last_Name + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
