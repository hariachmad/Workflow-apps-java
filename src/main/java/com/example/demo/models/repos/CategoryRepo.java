package com.example.demo.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category,Integer> {
    
}
