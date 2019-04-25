package com.zjw.CRUDS;

import com.zjw.entity.Customer;
import org.hibernate.*;
import org.hibernate.cfg.*;

import java.util.List;


public class CrudsOps {


    public static void main(String arg[]){
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();
            Session session = factory.openSession();

            try {
                session.beginTransaction();
                List<Customer> theCustomers = session.createQuery("from Customer").getResultList();
                displayCustomers(theCustomers);
                theCustomers = session.createQuery("from Customer s where s.lastName='Doe'").getResultList();
                System.out.println("\n\nCustomers who have last name of Doe");
                displayCustomers(theCustomers);
                // query students: lastName='Doe' OR firstName='Daffy'
                theCustomers =
                        session.createQuery("from Customer s where"
                                + " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

                System.out.println("\n\nCustomers who have last name of Doe OR first name Daffy");
                displayCustomers(theCustomers);

                // query students where email LIKE '%gmail.com'
                theCustomers = session.createQuery("from Customer s where"
                        + " s.email LIKE '%gmail.com'").getResultList();

                System.out.println("\n\nCustomers whose email ends with gmail.com");
                displayCustomers(theCustomers);

                // commit transaction
                session.getTransaction().commit();

                System.out.println("Done!");
            }
            finally {
                factory.close();
            }
        }

    private static void displayCustomers(List<Customer> theCustomers) {
        for (Customer tempCustomer : theCustomers) {
            System.out.println(tempCustomer);
        }
    }


}
