package com.arma.springbootMyGoalsarma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.arma.springbootMyGoalsarma.exception.ResourceNotFoundException;
import com.arma.springbootMyGoalsarma.model.Category;
import com.arma.springbootMyGoalsarma.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Category goal = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
        return ResponseEntity.ok().body(goal);
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category goal) {
        return categoryRepository.save(goal);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long id,
            @Valid @RequestBody Category goalDetails) throws ResourceNotFoundException {
        Category goal = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));

        goal.setName(goalDetails.getName());
        final Category updatedCategory = categoryRepository.save(goal);
        return ResponseEntity.ok(updatedCategory);
    }
}
