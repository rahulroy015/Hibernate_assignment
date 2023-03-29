package com.gl.HibernateProject;

import com.gl.HibernateProject.config.HibernateConfig;
import com.gl.HibernateProject.entity.Course;
import com.gl.HibernateProject.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppOnetoMany {
  private static SessionFactory factory = HibernateConfig.getSessionFactory();
  public static void main( String[] args ) {
    Student s1 = new Student();
    s1.setStudentid("S006");
    s1.setStudentname("Lav");

    List<Course> courses = new ArrayList<Course>();
    Course p1 = new Course();
    p1.setCid(24);
    p1.setCname("Java");
    p1.setPrice(75000);
    p1.setDescription("Programming Language");
    p1.setStudent(s1);

    courses.add(p1);

    p1 = new Course();
    p1.setCname("React");
    p1.setCid(25);
    p1.setPrice(18000);
    p1.setDescription("UI Framework");
    p1.setStudent(s1);

    courses.add(p1);

    s1.setCourses(courses);

    p1.setCid(3);

//    Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		for(Course p : courses)
//		session.save(p);
//		session.remove(s1);
//
//		//session.persist(s1);
//		tx.commit();
//		session.close();
  }

}
