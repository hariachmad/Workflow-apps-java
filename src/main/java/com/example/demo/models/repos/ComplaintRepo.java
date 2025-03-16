package com.example.demo.models.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.entities.Complaint;

public interface ComplaintRepo extends CrudRepository<Complaint, Integer> {
    
}
