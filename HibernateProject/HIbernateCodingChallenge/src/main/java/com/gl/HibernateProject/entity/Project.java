package com.gl.HibernateProject.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "projectid")
  private int project_id;
  private String project_name;
  private String project_description;
  @ManyToMany(mappedBy = "projects")
  private Set<Employee> employees = new HashSet<>();
  public Project(){

  }

  public Project(int project_id, String project_name, String project_description, Set<Employee> employees) {
    this.project_id = project_id;
    this.project_name = project_name;
    this.project_description = project_description;
    this.employees = employees;
  }

  public int getProject_id() {
    return project_id;
  }

  public void setProject_id(int project_id) {
    this.project_id = project_id;
  }

  public String getProject_name() {
    return project_name;
  }

  public void setProject_name(String project_name) {
    this.project_name = project_name;
  }

  public String getProject_description() {
    return project_description;
  }

  public void setProject_description(String project_description) {
    this.project_description = project_description;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "Project{" +
      "project_id=" + project_id +
      ", project_name='" + project_name + '\'' +
      ", project_description='" + project_description + '\'' +
      ", employees=" + employees +
      '}';
  }
}
