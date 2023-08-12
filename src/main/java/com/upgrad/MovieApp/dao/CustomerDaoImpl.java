package com.upgrad.MovieApp.dao;

import com.upgrad.MovieApp.Entities.Customer;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDAO{

    private SessionFactory sessionFactory;
    @Autowired
    public CustomerDaoImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory  = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public Customer save(Customer customer) {
        Session session = sessionFactory.openSession();
        //Transient stage
        Transaction transaction = session.beginTransaction();
        //Persistance stage
        session.save(customer);
        transaction.commit();
        //Detached stage.
        session.close();
        return customer;
    }

    @Override
    public Customer get(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer mergedCustomer = session.merge(customer);

        session.delete(mergedCustomer);
        transaction.commit();
        session.close();
    }
}
