package com.example.projectx.controller;

import com.example.projectx.entity.Product;
import com.example.projectx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping(value = "/products")
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/products/{productId}")
    public Product getProduct(@PathVariable int productId){
        Product theProduct = productService.getProductById(productId);

        if(theProduct == null){
            throw new RuntimeException("product with id not found- " + productId);
        }
        return theProduct;
    }



    @PostMapping(value = "/products")
    public Product addProduct(@RequestBody Product theProduct){

        //also just in case they pass an id in Json ...set id to 0
        //this si to force a save of new item ... instead of update

        theProduct.setId(0);
        productService.saveProduct(theProduct);
        return theProduct;


    }

    //add mapping for Put/employees update existing employee

    @PutMapping(value = "/products")
    public Product updateProduct(@RequestBody Product theProduct){
        productService.saveProduct(theProduct);
        return theProduct;
    }
    //add mapping for Delete/employees/{employeeId} -delete employee


    @DeleteMapping(value = "/products/{productId}")
    public String deleteEmployee(@PathVariable int productId){

        Product theProduct = productService.getProductById(productId);

        if(theProduct == null){
            throw new RuntimeException("Employee id not found - " + productId);
        }
        productService.deleteProductById(productId);
        return "Deleting employee with id: "+productId;
    }


}
