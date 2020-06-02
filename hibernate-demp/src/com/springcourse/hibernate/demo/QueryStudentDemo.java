package com.springcourse.hibernate.demo;

import com.springcourse.jdbc.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {


            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName='Donald' ").getResultList();
            displayStudents(students);

            session.getTransaction().commit();

            System.out.println("Transaction complete");

        }
        finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
