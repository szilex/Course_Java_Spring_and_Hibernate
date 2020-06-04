package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.entity.Course;
import com.springcourse.hibernate.entity.Instructor;
import com.springcourse.hibernate.entity.InstructorDetail;
import com.springcourse.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseWithReviewsDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Course course = new Course("Java Programming Masterclass");

            course.addReview(new Review("fantastic course :)"));
            course.addReview(new Review("I've never took such a good course :)"));
            course.addReview(new Review("I expected more"));
            course.addReview(new Review("Good enough"));

            session.save(course);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
