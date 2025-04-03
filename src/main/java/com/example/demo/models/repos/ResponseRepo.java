package com.example.demo.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entities.Response;

public interface ResponseRepo extends CrudRepository<Response,Integer> {
    
}
