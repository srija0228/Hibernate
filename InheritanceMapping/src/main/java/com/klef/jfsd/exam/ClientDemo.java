package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert a Device
        Device device = new Device();
        device.setBrand("Generic Brand");
        device.setModel("Generic Model");
        device.setPrice(300.0);
        session.save(device);

        // Insert a Smartphone
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Samsung");
        smartphone.setModel("Galaxy S23");
        smartphone.setPrice(1200.0);
        smartphone.setOperatingSystem("Android");
        smartphone.setCameraResolution("108MP");
        session.save(smartphone);

        // Insert a Tablet
        Tablet tablet = new Tablet();
        tablet.setBrand("Apple");
        tablet.setModel("iPad Pro");
        tablet.setPrice(1500.0);
        tablet.setScreenSize("12.9 inches");
        tablet.setBatteryLife("10 hours");
        session.save(tablet);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Records inserted successfully!");
    }
}
