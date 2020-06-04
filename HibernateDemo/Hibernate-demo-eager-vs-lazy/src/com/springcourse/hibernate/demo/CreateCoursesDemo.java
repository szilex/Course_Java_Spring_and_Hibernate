package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.demo.entity.Course;
import com.springcourse.hibernate.demo.entity.Instructor;
import com.springcourse.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            Course course = new Course("Guide to life and everything");
            Course course1 = new Course("Guitar hero course");

            instructor.add(course);
            instructor.add(course1);

            session.save(course);
            session.save(course1);

            session.getTransaction().commit();
        }
        finally {

            session.close();
            sessionFactory.close();
        }
    }
}
