/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.resource;

import java.io.File;
import lk.ijse.mscs.entity.Accessories;
import lk.ijse.mscs.entity.Batch;
import lk.ijse.mscs.entity.Customer;
import lk.ijse.mscs.entity.CustomerOrder;
import lk.ijse.mscs.entity.FinishedRepair;
import lk.ijse.mscs.entity.GRN;
import lk.ijse.mscs.entity.Item;
import lk.ijse.mscs.entity.MobileOperater;
import lk.ijse.mscs.entity.OrderDetail;
import lk.ijse.mscs.entity.Reception;
import lk.ijse.mscs.entity.Supplier;
import lk.ijse.mscs.entity.SupplierOrder;
import lk.ijse.mscs.entity.Warranty;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ranjith-suranga
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    private static StandardServiceRegistry registry;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.

            // (1) 
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();

            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Accessories.class)
                    .addAnnotatedClass(Batch.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(CustomerOrder.class)
                    .addAnnotatedClass(OrderDetail.class)
                    .addAnnotatedClass(FinishedRepair.class)
                    .addAnnotatedClass(GRN.class)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(MobileOperater.class)
                    .addAnnotatedClass(Reception.class)
                    .addAnnotatedClass(Supplier.class)
                    .addAnnotatedClass(SupplierOrder.class)
                    .addAnnotatedClass(Warranty.class)
                    .buildMetadata().buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);

            StandardServiceRegistryBuilder.destroy(registry);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
