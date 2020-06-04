package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseWithStudentsDemo {

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

            Course course = new Course("Java Programming Masterclass");

            session.save(course);

            System.out.println("Course saved: " + course);

            Student firstStudent = new Student("John", "Adams", "email@email.com");
            Student secondStudent = new Student("Michael", "Jordan", "nba@email.com");
            Student thirdStudent = new Student("Barack", "Obama", "president@email.com");

            course.addStudent(firstStudent);
            course.addStudent(secondStudent);
            course.addStudent(thirdStudent);

            System.out.println("Added students:");
            course.getStudents().forEach(System.out::println);

            session.save(firstStudent);
            session.save(secondStudent);
            session.save(thirdStudent);

            System.out.println("Saved students");

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
