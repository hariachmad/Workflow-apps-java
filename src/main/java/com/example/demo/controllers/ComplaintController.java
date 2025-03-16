package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entities.Complaint;
import com.example.demo.services.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public Iterable<Complaint> getAll() {
        return complaintService.findAll();
    }
    
    @GetMapping("/find")
    public Complaint get(@RequestParam Integer id){
        return complaintService.findOne(id);
    }

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint){
        return complaintService.save(complaint);
    }

}
