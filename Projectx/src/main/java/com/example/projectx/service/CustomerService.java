package com.example.projectx.service;

import com.example.projectx.entity.Customer;


import java.util.List;


public interface CustomerService {


    public List<Customer> getAllCustomers();
    public boolean checkCustomer(Customer theCustomer);
    public void saveCustomer(Customer theCustomer);
    public void deleteCustomerById(long theId);
}


