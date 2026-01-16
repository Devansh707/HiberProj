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
        Student st = new Student();
        st.setRollNo(13);
        st.setsAge(22);
        st.setsName("Harry12 ");

        Student s2 = null;

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();
//        SessionFactory sf = cfg.buildSessionFactory();
        SessionFactory sf = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();

        Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();
        s2 = session.get(Student.class, 12);

        session.save(st);

//        transaction.commit();
        System.out.println(st);

        System.out.println(s2);

        session.close();
        sf.close();
    }
}