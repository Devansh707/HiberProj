package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure().buildSessionFactory();

        Session session = sf.openSession();

        // To get all the laptops where RAM = 32
        // SQL -> SELECT * FROM Laptop WHERE ram = 32;
        // HQL -> FROM Laptop WHERE ram = 32

//        Query query = session.createQuery("FROM Laptop");
        Query query = session.createQuery("FROM Laptop WHERE ram = 32");
        List<Laptop> laptops = query.getResultList();

        System.out.println("All Laptops: ");
        for(Laptop l : laptops) {
            System.out.println(l);
        }


        Laptop l1 = session.get(Laptop.class, 5); // fetching laptop with lid = 5
        System.out.println("Laptop fetched: " + l1);

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