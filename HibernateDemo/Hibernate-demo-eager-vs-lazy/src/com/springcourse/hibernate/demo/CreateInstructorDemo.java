package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.demo.entity.Course;
import com.springcourse.hibernate.demo.entity.Instructor;
import com.springcourse.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {


            Instructor instructor = new Instructor(
                    "Jimbo",
                    "Guns",
                    "yiha@email.com"
            );

            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.pinterest.com/horses",
                    "Riding horses"
            );

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }
        finally {

            session.close();
            sessionFactory.close();
        }
    }
}
