package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.entity.Course;
import com.springcourse.hibernate.entity.Instructor;
import com.springcourse.hibernate.entity.InstructorDetail;
import com.springcourse.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseWithReviewsDemo {

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

            int id = 10;

            Course course = session.get(Course.class, id);
            course.getReviews().forEach(System.out::println);

            session.save(course);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
