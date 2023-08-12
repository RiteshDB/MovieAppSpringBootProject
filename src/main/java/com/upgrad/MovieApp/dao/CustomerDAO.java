package com.upgrad.MovieApp.dao;

import com.upgrad.MovieApp.Entities.Customer;

public interface CustomerDAO {

    public Customer save(Customer customer);

    public Customer get(int id);

    public Customer update(Customer customer);

    public void delete(Customer customer);
}
