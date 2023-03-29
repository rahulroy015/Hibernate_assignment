package com.gl.HibernateProject;

import com.gl.HibernateProject.config.HibernateConfig;
import com.gl.HibernateProject.entity.Employee;
import com.gl.HibernateProject.entity.Project;
import com.gl.HibernateProject.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppManytoMany {
  private static SessionFactory factory = HibernateConfig.getSessionFactory();
  public static void main( String[] args ) {
    Session session = factory.openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      Employee employee = new Employee();
      employee.setEmp_name("John");
      employee.setEmp_email("lav@gmail.com");

      Project project1 = new Project();
      project1.setProject_name("Project 1");
      project1.setProject_description("GL");

      Project project2 = new Project();
      project2.setProject_name("Project 2");
      project2.setProject_description("Hibernate");

      employee.getProjects().add(project1);
      employee.getProjects().add(project2);

      session.persist(employee);

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }

  }
//    Session session = factory.openSession();
//
//
//// Fetch all employee names for a given project ID
//    List<Employee> employees = session.createQuery(
//        "SELECT e FROM Employee e JOIN e.projects p WHERE p.id = :projectId", Employee.class)
//      .setParameter("projectId", project_id)
//      .getResultList();
//
//// Fetch all project names for a given employee
//    List<Project> projects = session.createQuery(
//        "SELECT p FROM Project p JOIN p.employees e WHERE e.id = :employeeId", Project.class)
//      .setParameter("employeeId", emp_id)
//      .getResultList();
//
//    session.close();



}
