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
//        Query query = session.createQuery("FROM Laptop WHERE ram = 32");
        Query query = session.createQuery("FROM Laptop WHERE  brand Like 'Asus'");

        String brand = "Asus";
        Query query1 = session.createQuery("FROM Laptop WHERE brand = ?1"); // passing external parameter to the query
        query1.setParameter(1, brand);

        List<Laptop> laptops = query1.getResultList();

        System.out.println("All Laptops: ");
        for(Laptop l : laptops) {
            System.out.println(l);
        }

//        fetching only specific columns -> fetch model names of laptops having brand = 'Asus'
        Query query2 = session.createQuery("select model from Laptop where  brand = ?1");
        query2.setParameter(1, brand);

        List<String> models = query2.getResultList();
        System.out.println("Models of laptops having brand Asus: ");
        for(String m : models) {
            System.out.println(m);
        }

//        Fetching 2 columns -> brand and model of laptops
        Query query3 = session.createQuery("select brand, model from Laptop where  brand = ?1");
        query3.setParameter(1, brand);
        List<Object[]> list = query3.getResultList();
        System.out.println("Brand and Model of laptops having brand Asus: ");
        for(Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
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