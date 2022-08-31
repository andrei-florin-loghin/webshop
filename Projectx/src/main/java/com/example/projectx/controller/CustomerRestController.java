package com.example.projectx.controller;

import com.example.projectx.entity.Customer;
import com.example.projectx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value="/register")
    public String register(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return "account successfully added";

    }

    @GetMapping(value ="/auth")
    public String auth(@RequestBody Customer customer){
        if(customerService.checkCustomer(customer)){
            return "successfully authentication";
        }
        else{
            return "try again";
        }
    }

    @DeleteMapping(value ="/delete/{theid}")
    public void deleteCustomer(@PathVariable Long theid){

           customerService.deleteCustomerById(theid);

    }

    @GetMapping(value ="/customers")
    public List<Customer> getCustomers(){
       return customerService.getAllCustomers();
    }



}
