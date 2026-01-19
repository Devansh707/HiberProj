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


        Laptop l1 = new Laptop();
        l1.setLid(01);
        l1.setBrand("Dell");
        l1.setModel("Inspiron");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Yash");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration().addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure().buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(a1);

        transaction.commit();

        Alien retrievedAlien = session.find(Alien.class, 101);
        System.out.println("Retrieved Alien: " + retrievedAlien);

        session.close();
        sf.close();
    }
}