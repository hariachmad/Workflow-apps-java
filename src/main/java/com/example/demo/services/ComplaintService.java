package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.Complaint;
import com.example.demo.models.repos.ComplaintRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComplaintService {
    @Autowired
    private ComplaintRepo complaintRepo;

    public Complaint save(Complaint complaint){
        try {
            return complaintRepo.save(complaint);    
        } catch (Exception e) {
            throw e;
        }
        
    };

    public Complaint findOne(Integer id){
        return complaintRepo.findById(id).get();
    }

    public Iterable<Complaint> findAll(){
        return complaintRepo.findAll();
    }

    public void removeOne(Integer id){
        complaintRepo.deleteById(id);
    }
}
