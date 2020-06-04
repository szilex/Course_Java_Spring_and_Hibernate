package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.demo.entity.Course;
import com.springcourse.hibernate.demo.entity.Instructor;
import com.springcourse.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchJoinDemo {

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

            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses WHERE i.id=:instructorId");
            query.setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            session.getTransaction().commit();

            System.out.println("Instructor courses: " + instructor.getCourses());

            session.close();
        }
        finally {

            sessionFactory.close();
        }
    }
}
