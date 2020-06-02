package com.springcourse.hibernate.demo;

import com.springcourse.jdbc.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args  ) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
/*            int studentId = 1;
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            session.delete(student);

            session.getTransaction().commit();*/

            session.beginTransaction();

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
