package com.example.demo.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entities.User;


public interface UserRepo extends CrudRepository<User, Integer> {
    
}
