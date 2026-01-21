package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Laptop l1 = makeLaptop(1, "Dell", "Inspiron", 16);
        Laptop l2 = makeLaptop(2, "Apple", "MacBook Pro", 32);
        Laptop l3 = makeLaptop(3, "HP", "Pavilion", 8);
        Laptop l4 = makeLaptop(4, "Lenovo", "ThinkPad", 16);

        Alien a1 = makeAlien(101, "Yash", "Java");
        Alien a2 = makeAlien(102, "John", "Python");
        Alien a3 = makeAlien(103, "Alice", "C++");

        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l2, l3));
        a3.setLaptops(Arrays.asList(l1, l4));

        l1.setAliens(Arrays.asList(a1, a2));
        l2.setAliens(Arrays.asList(a1, a3));
        l3.setAliens(Arrays.asList(a2));
        l4.setAliens(Arrays.asList(a3));

        SessionFactory sf = new Configuration().addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure().buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(l4);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();

        Alien retrievedAlien = session.find(Alien.class, 101);
        System.out.println("Retrieved Alien: " + retrievedAlien);

        session.close();
        sf.close();
    }
    public static Alien makeAlien(int id, String name, String tech) {
        Alien alien = new Alien();
        alien.setAid(id);
        alien.setAname(name);
        alien.setTech(tech);
        return alien;
    }

    public static Laptop makeLaptop(int id, String brand, String model, int ram) {
        Laptop laptop = new Laptop();
        laptop.setLid(id);
        laptop.setBrand(brand);
        laptop.setModel(model);
        laptop.setRam(ram);
        return laptop;
    }
}