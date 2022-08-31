package com.example.projectx.repository;

import com.example.projectx.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //extend it to get crud methods
    //no need of implementation class
    //provides @Transactional functionality
}
