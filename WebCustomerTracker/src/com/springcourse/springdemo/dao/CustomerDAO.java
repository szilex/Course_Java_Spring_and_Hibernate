package com.springcourse.springdemo.dao;

import com.springcourse.springdemo.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);
}
