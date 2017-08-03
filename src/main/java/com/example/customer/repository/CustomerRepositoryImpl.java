package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by JamesHartanto on 8/3/17.
 */
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Add a customer
    private final String INSERT_SQL = "INSERT INTO customer (firstname, lastname, phone, email) VALUES (?,?,?,?)";
    @Override
    public void addCustomer(Customer customer){
        jdbcTemplate.update(INSERT_SQL, customer.getFirstName(),customer.getLastName(),customer.getPhone(),customer.getEmail());
    }

    // Update customer
    private final String UPDATE_SQL = "UPDATE customer " +
            "SET firstname = ?, lastname = ?, phone = ?, email = ? " +
            "WHERE id = ?";
    @Override
    public void updateCustomer(Customer customer){
        jdbcTemplate.update(UPDATE_SQL, customer.getFirstName(),customer.getLastName(),customer.getPhone(),customer.getEmail(),customer.getId());
    }

    // Get a customer
    private final String SELECT_BY_ID_SQL = "SELECT * FROM customer WHERE id = ?";
    @Override
    public Customer getByIdCustomer(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL,new CustomerMapper(), id);
    }

    // Get all customers
    private final String GET_ALL_SQL = "SELECT * FROM customer";
    @Override
    public List<Customer> getAllCustomer() {
        return jdbcTemplate.query(GET_ALL_SQL, new CustomerMapper());
    }

    // Delete a customer
    private final String DELETE_BY_ID_SQL = "DELETE FROM customer WHERE id = ?";
    @Override
    public void deleteCustomer(int id) {
        jdbcTemplate.update(DELETE_BY_ID_SQL,id);
    }

    // Delete multiple customers
    public void deleteMoreCustomer(List<Integer> id) {
//        for (int x = 0; x < id.size(); x = x + 1){
//            deleteCustomer(x);
//        }
        for (int ids : id){
            deleteCustomer(ids);
        }
    }


    private static class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("firstname"));
            customer.setLastName(rs.getString("lastname"));
            customer.setPhone(rs.getString("phone"));
            customer.setEmail(rs.getString("email"));

            return customer;
        }

    }

}
