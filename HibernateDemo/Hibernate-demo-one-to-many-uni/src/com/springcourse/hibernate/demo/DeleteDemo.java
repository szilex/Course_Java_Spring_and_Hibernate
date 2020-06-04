package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.entity.Instructor;
import com.springcourse.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            int id = 2;
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 2);

            if (instructor != null) {
                session.delete(instructor);
            }

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

}
