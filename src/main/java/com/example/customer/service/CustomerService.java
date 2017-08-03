package com.example.customer.service;

import com.example.customer.model.Customer;

import java.util.List;

/**
 * Created by JamesHartanto on 8/3/17.
 */
public interface CustomerService {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getByIdCustomer(int id);
    List<Customer> getAllCustomer();
    void deleteCustomer(int id);
    void deleteMoreCustomer(List<Integer> id);
}
