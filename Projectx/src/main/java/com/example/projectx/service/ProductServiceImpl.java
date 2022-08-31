package com.example.projectx.service;


import com.example.projectx.entity.Product;
import com.example.projectx.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long theId) {
        Optional<Product> result = productRepository.findById(theId);
        Product theProduct = null;
        if(result.isPresent()){ //check for not null
            theProduct=result.get(); //get product with the indicated id
        }else{
            throw new RuntimeException("did not find the product id: " + theId);
        }
        return theProduct;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void deleteProductById(long theId) {
        productRepository.deleteById(theId);

    }
}
