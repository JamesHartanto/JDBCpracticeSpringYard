package com.example.customer.service;

import com.example.customer.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JamesHartanto on 8/3/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet(){
        // Creating 3 customers
        Customer customer1 = new Customer();
        customer1.setFirstName("bob");
        customer1.setLastName("bobby");
        customer1.setPhone("1");
        customer1.setEmail("11");

        Customer customer2 = new Customer();
        customer2.setFirstName("bill");
        customer2.setLastName("billy");
        customer2.setPhone("2");
        customer2.setEmail("22");

        Customer customer3 = new Customer();
        customer3.setFirstName("first");
        customer3.setLastName("last");
        customer3.setPhone("3");
        customer3.setEmail("33");

        // adding the customers
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);

        Assert.assertEquals(customerService.getAllCustomer().size(),3);
    }

    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setFirstName("Bill");
        customer.setLastName("Last");
        customer.setPhone("1");
        customer.setEmail("Zap");

        customerService.addCustomer(customer);

        customer.setFirstName("Bob");
        customer.setLastName("Bob");
        customer.setPhone("huh");
        customer.setEmail("Bill");

        customerService.updateCustomer(customer);
        Assert.assertEquals(customerService.getByIdCustomer(6).getFirstName(),"Bob");
    }
}
