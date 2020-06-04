package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.demo.entity.Course;
import com.springcourse.hibernate.demo.entity.Instructor;
import com.springcourse.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo {

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
            List<Course> courses = instructor.getCourses();

            session.getTransaction().commit();
            session.close();

            // courses = instructor.getCourses();
            courses.forEach(System.out::println);


        }
        finally {


            sessionFactory.close();
        }
    }
}
