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
public class CategoryController {
    @Autowired
    private CategoryJpaService service;

    @GetMapping("/categorys")
    public ArrayList<Category> getCategorys() {
        return service.getCategorys();
    }

    @GetMapping("/categorys/{id}")
    public Category getCategoryById(@PathVariable("id") int id) {
        return service.getCategoryById(id);
    }

    @PostMapping("/categorys")
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }

    @PutMapping("/categorys/{id}")
    public Category updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/categorys/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        service.deleteCategory(id);
    }
}