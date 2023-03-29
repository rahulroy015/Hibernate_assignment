package com.gl.HibernateProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cid;
  private String cname;
  private String description;
  private double price;
  @ManyToOne (cascade = CascadeType.REFRESH)
  @JoinColumn(name="studentid")
  private Student student;

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
