package com.example.projectx.service;

import com.example.projectx.entity.Product;

import java.util.List;


public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(long theId);
    public void saveProduct(Product product);
    public void deleteProductById(long theId);
}
