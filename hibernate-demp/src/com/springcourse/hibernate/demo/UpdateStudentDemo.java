package com.springcourse.hibernate.demo;

import com.springcourse.jdbc.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            int id = 1;
            session.beginTransaction();
            Student student = session.get(Student.class, id);

            System.out.println("Updating student...");

            student.setFirstName("Ferdinand");

            session.getTransaction().commit();

            session = sessionFactory.openSession();
            session.beginTransaction();

            session.createQuery("update Student set email='default@email.com'").executeUpdate();
            session.getTransaction().commit();

        }
        finally {
            sessionFactory.close();
        }
    }
}
