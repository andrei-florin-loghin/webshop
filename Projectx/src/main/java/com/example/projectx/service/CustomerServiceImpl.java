package com.example.projectx.service;

import com.example.projectx.entity.Customer;
import com.example.projectx.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.regex.*;



@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public boolean checkCustomer(Customer theCustomer) {
        String passwordEncoded = new String(Base64.getEncoder().encode(theCustomer.getPassword().getBytes()));
        return customerRepository.findCustomerByEmailAndPassword(theCustomer.getEmail(), passwordEncoded) != null;
    }




    @Override
    public void saveCustomer(Customer theCustomer) {
        String customerEmail= theCustomer.getEmail();
        String customerPassword =theCustomer.getPassword();
        if((!customerEmail.isEmpty()) && (!customerPassword.isEmpty())){ //datele introduse nu sunt vide
            if(isValidEmail(customerEmail)){//email ul are formatul valid
                if(customerRepository.findCustomerByEmail(customerEmail) == null){ //userul nu exista in baza de date
                    theCustomer.setPassword(new String(Base64.getEncoder().encode(customerPassword.getBytes())));
                    customerRepository.save(theCustomer);
                }else{
                    throw new RuntimeException("email already in the sistem");}
                }else{
                    throw new RuntimeException("wrong format email");
                }
                    }else {
        throw new RuntimeException("please insert email and password");
    }

}

    @Override
    public void deleteCustomerById(long theId) {

        customerRepository.deleteById(theId);
    }

    private boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if(email == null)
            return false;
        return pat.matcher(email).matches();
}





}
