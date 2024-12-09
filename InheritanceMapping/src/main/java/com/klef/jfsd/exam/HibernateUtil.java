package com.klef.jfsd.exam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Create Configuration instance
            Configuration configuration = new Configuration();

            // Set Hibernate properties
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/labexam");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "Srija@12345");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");

            // Add annotated classes dynamically
            configuration.addAnnotatedClass(com.klef.jfsd.exam.Device.class);
            configuration.addAnnotatedClass(com.klef.jfsd.exam.Smartphone.class);
            configuration.addAnnotatedClass(com.klef.jfsd.exam.Tablet.class);

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex.getMessage());
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // For testing the setup
    public static void main(String[] args) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            System.out.println("Hibernate configured successfully!");
            factory.close();
        } catch (Exception e) {
            System.err.println("Hibernate configuration failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
