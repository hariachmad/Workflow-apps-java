package com.example.demo.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entities.Observer;

public interface ObserverRepo extends CrudRepository<Observer,Integer> {
    
}
