package com.springcourse.hibernate.demo;

import com.springcourse.jdbc.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            System.out.println("Creating new student object...");
            Student student1 = new Student("Albert", "Einstein", "mc2e@email.com");
            Student student2 = new Student("Mark", "Smith", "agentsmith@email.com");
            Student student3 = new Student("Jake", "Paul", "youtuber@email.com");
            System.out.println("Saving the student...");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3   );
            session.getTransaction().commit();

            System.out.println("Transaction complete");

        }
        finally {
            sessionFactory.close();
        }
    }
}
