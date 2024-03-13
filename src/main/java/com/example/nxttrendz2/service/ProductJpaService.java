/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.nxttrendz2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz2.repository.*;
import com.example.nxttrendz2.model.*;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository repository;

    @Override
    public ArrayList<Product> getProducts() {
        List<Product> list = repository.findAll();
        ArrayList<Product> products = new ArrayList<>(list);
        return products;
    }

    @Override
    public Product getProductById(int id) {
        try {
            Product products = repository.findById(id).get();
            return products;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        repository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        try {
            Product products = repository.findById(id).get();

            if (product.getName() != null) {
                products.setName(product.getName());
            }
            if (product.getDescription() != null) {
                products.setDescription(product.getDescription());
            }
            if (product.getPrice() != 0) {
                products.setPrice(product.getPrice());
            }

            repository.save(products);
            return products;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    @Override
    public Category getCategoryProduct(int id) {
        try {
            Product product = repository.findById(id).get();
            return product.getCategory();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}