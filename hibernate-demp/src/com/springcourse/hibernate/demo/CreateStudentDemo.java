package com.springcourse.hibernate.demo;

import com.springcourse.jdbc.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            System.out.println("Creating new student object...");
            Student student = new Student("John", "Doe", "johndoe@mail.com");

            System.out.println("Saving the student...");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            System.out.println("Transaction complete");

        }
        finally {
            sessionFactory.close();
        }
    }
}
