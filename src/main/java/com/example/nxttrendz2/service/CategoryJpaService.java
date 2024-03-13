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
public class CategoryJpaService implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository repository;

    @Override
    public ArrayList<Category> getCategorys() {
        List<Category> list = repository.findAll();
        ArrayList<Category> categorys = new ArrayList<>(list);
        return categorys;
    }

    @Override
    public Category getCategoryById(int id) {
        try {
            Category categorys = repository.findById(id).get();
            return categorys;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category addCategory(Category category) {
        repository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        try {
            Category categorys = repository.findById(id).get();

            if (category.getName() != null) {
                categorys.setName(category.getName());
            }
            if (category.getDescription() != null) {
                categorys.setDescription(category.getDescription());
            }

            repository.save(categorys);
            return categorys;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCategory(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }
}