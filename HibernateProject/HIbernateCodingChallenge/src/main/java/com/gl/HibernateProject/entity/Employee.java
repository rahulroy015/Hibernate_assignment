package com.gl.HibernateProject.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int emp_id;
  private String emp_name;
  private String emp_email;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id"))
  private Set<Project> projects = new HashSet<>();
  public Employee(){

  }


  public Employee(int emp_id, String emp_name, String emp_email, Set<Project> projects) {
    this.emp_id = emp_id;
    this.emp_name = emp_name;
    this.emp_email = emp_email;
    this.projects = projects;
  }

  public int getEmp_id() {
    return emp_id;
  }

  public void setEmp_id(int emp_id) {
    this.emp_id = emp_id;
  }

  public String getEmp_name() {
    return emp_name;
  }

  public void setEmp_name(String emp_name) {
    this.emp_name = emp_name;
  }

  public String getEmp_email() {
    return emp_email;
  }

  public void setEmp_email(String emp_email) {
    this.emp_email = emp_email;
  }

  public Set<Project> getProjects() {
    return projects;
  }

  public void setProjects(Set<Project> projects) {
    this.projects = projects;
  }
}
