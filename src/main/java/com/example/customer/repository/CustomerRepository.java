package com.example.customer.repository;
import com.example.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JamesHartanto on 8/3/17.
 */
@Repository
public interface CustomerRepository {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getByIdCustomer(int id);
    List<Customer> getAllCustomer();
    void deleteCustomer(int id);
    void deleteMoreCustomer(List<Integer> id);
}
