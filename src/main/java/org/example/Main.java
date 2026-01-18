package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Yash");
        a1.setTech("Java");

        SessionFactory sf = new Configuration().addAnnotatedClass(Alien.class).configure().buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(a1);

        transaction.commit();

        session.close();
        sf.close();
    }
}