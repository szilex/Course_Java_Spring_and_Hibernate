package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.entity.Instructor;
import com.springcourse.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            int id = 5;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor details: " + instructorDetail);
            System.out.println("Instructor: " + instructorDetail.getInstructor());
            System.out.println("Deleting instructor");

            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);

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
