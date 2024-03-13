/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxttrendz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.nxttrendz2.service.*;
import com.example.nxttrendz2.model.*;

@RestController
public class ProductController {
    @Autowired
    private ProductJpaService service;

    @GetMapping("/categories/products")
    public ArrayList<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/categories/products/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return service.getProductById(id);
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/categories/products/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/categories/products/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id);
    }

    @GetMapping("/products/category/{id}")
    public Category getCategoryProduct(@PathVariable("id") int id) {
        return service.getCategoryProduct(id);
    }
}