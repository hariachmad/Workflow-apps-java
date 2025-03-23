package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.entities.Complaint;
import com.example.demo.services.ComplaintService;

import jakarta.validation.Valid;

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
    public Complaint save(@Valid @RequestBody Complaint complaint,Errors errors){
        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                System.err.println(error.getDefaultMessage());
            }
            throw new RuntimeException("Validation Error");
        }
        try {
            return complaintService.save(complaint);    
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Gagal Menyimpan data ke database");
        }
    }

}
