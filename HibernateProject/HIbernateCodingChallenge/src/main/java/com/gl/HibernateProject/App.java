package com.gl.HibernateProject;

import com.gl.HibernateProject.config.HibernateConfig;
import com.gl.HibernateProject.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class App {
  private static SessionFactory factory = HibernateConfig.getSessionFactory();
  public static void main( String[] args )
  {
    Teacher t1=new Teacher(1,"Lav","Kumar","Kumarlav@gmail.com");
//    System.out.println(t1);
    //System.out.println(insertTeacher(t1));
    // create a new teacher
//    Teacher t1=new Teacher(1,"Lav","Kumar","Kumarlav@gmail.com");
//    System.out.println("Created teacher with id: " + insertTeacher(t1));

//    // update the teacher
//    Teacher t2 = getTeacherById(1);
//    t2.setFirst_Name("John");
//    t2.setLast_Name("Doe");
//    updateTeacher(t2);
//    System.out.println("Updated teacher: " + t2);

//    // delete the teacher
//    Teacher t3 = getTeacherById(1);
//    deleteTeacher(t3);
//    System.out.println("Deleted teacher with id: " + t3.getId());
//
    // get all teachers
    List<Teacher> teachers = getAllTeachers();
    System.out.println("All teachers: " + teachers);
  }
  public static int insertTeacher(Teacher teacher)
  {
    // Create a session
    // DML commit => transaction
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    session.persist(teacher);
    tx.commit();
    session.close();
    return teacher.getId();
  }
  public static Teacher updateTeacher(Teacher teacher)
  {
    // Create a session
    // DML commit => transaction
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    Teacher updatedTeacher = session.merge(teacher);
    tx.commit();
    session.close();
    return updatedTeacher;
  }
  // remove and delete
  public static void deleteTeacher(Teacher teacher)
  {
    // Create a session
    // DML commit => transaction
    Session session = factory.openSession();
    Transaction tx = session.beginTransaction();
    session.remove(teacher);
    tx.commit();
    session.close();
  }
  public static Teacher getTeacherById(int teacherid)
  {
    Session session = factory.openSession();
    Teacher teacher = session.get(Teacher.class, teacherid);
    session.close();
    return teacher;
  }
  public static Teacher loadTeacherById(int teacherid)
  {
    Session session = factory.openSession();
    Teacher teacher = new Teacher();

    teacher = session.load(Teacher.class, teacherid);

    session.close();
    return teacher;
  }

  public static List<Teacher> getAllTeachers()
  {
    Session session = factory.openSession();

    List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).getResultList();

    session.close();
    return teachers;
  }

}
