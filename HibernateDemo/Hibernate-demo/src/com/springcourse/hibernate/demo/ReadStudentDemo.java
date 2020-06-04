package com.springcourse.hibernate.demo;

import com.springcourse.jdbc.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            System.out.println("Creating new student object...");
            Student student = new Student("Donald", "Trump", "usapresident@email.com");

            System.out.println("Saving the student...");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();

            System.out.println("Transaction complete");


            System.out.println("Beginning second transaction...");

            session = sessionFactory.openSession();
            session.beginTransaction();

            System.out.println("New student id: " + student.getId());

            Student newStudent = session.get(Student.class, student.getId());

            System.out.println("Student got from database: " + student.toString());

            System.out.println("Second transaction done");


        }
        finally {
            sessionFactory.close();
        }
    }
}
