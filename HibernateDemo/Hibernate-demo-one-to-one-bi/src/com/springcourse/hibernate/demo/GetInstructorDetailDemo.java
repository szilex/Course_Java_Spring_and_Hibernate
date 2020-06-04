package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.demo.entity.Instructor;
import com.springcourse.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            int id = 1102;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor details: " + instructorDetail);
            System.out.println("Instructor: " + instructorDetail.getInstructor());

            session.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

}
