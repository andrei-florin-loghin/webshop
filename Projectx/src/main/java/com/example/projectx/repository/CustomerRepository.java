package com.example.projectx.repository;

import com.example.projectx.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

  //  @Query(value = "select * from customer a where a.email= :email and a.password= :password", nativeQuery = true)
   // boolean checkCustomer(@Param("email") String email,@Param("password")String password);

    Customer findCustomerByEmailAndPassword(@Param("email") String email,@Param("password") String password);
    Customer findCustomerByEmail(@Param("email") String email);

}
