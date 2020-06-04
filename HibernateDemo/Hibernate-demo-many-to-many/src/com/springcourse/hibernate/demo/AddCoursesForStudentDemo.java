package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            int id = 20;
            Student student = session.get(Student.class, id);

            System.out.println("Student: " + student);
            System.out.println("Student courses: " + student.getCourses());

            Course courseOne = new Course("Programming in Python");
            Course courseTwo = new Course("Programming in C++");
            Course courseThree = new Course("Programming in C#");

            courseOne.addStudent(student);
            courseTwo.addStudent(student);
            courseThree.addStudent(student);

            System.out.println("Saving courses");

            session.save(courseOne);
            session.save(courseTwo);
            session.save(courseThree);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
