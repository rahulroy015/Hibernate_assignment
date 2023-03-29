package com.gl.HibernateProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {

  @Id
  private String studentid;
  private String studentname;
  @OneToMany( //fetch = FetchType.EAGER,
    cascade = {  CascadeType.ALL}, mappedBy = "student")

  private List<Course> courses;

  public String getStudentid() {
    return studentid;
  }

  public void setStudentid(String studentid) {
    this.studentid = studentid;
  }

  public String getStudentname() {
    return studentname;
  }

  public void setStudentname(String studentname) {
    this.studentname = studentname;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
