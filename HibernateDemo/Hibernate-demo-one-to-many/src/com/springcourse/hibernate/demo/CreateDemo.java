package com.springcourse.hibernate.demo;

import com.springcourse.hibernate.demo.entity.Instructor;
import com.springcourse.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class CreateDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            /*Instructor instructor = new Instructor(
                    "Tim",
                    "Buchalka",
                    "javaacademy@aus.com"
            );

            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.udemy.com/javaacademy",
                    "Teaching java"
            );*/

            Instructor instructor = new Instructor(
                    "Jim",
                    "Jeans",
                    "jimms@email.com"
            );

            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.udemy.com/jimms",
                    "Play guitar"
            );

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
