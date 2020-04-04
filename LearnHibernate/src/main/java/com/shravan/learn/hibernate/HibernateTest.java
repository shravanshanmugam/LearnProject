package com.shravan.learn.hibernate;

import com.shravan.learn.hibernate.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateTest {

    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setUsername("Shravan");

        File file = new File("/home/shravan/webaroo/gitrepos/repo1/LearnHibernate/src/main/resources/hibernate.cfg.xml");
        final SessionFactory sessionFactory = new Configuration().configure(file).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();

    }
}
