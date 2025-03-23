package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

import com.example.demo.dto.ResponseData;
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
    public ResponseEntity<ResponseData<Complaint>> save(@Valid @RequestBody Complaint complaint,Errors errors){
        ResponseData<Complaint> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        try {
            responseData.setStatus(true);
            responseData.setPayload(complaintService.save(complaint));
            return ResponseEntity.ok(responseData);     
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Gagal Menyimpan data ke database");
        }
    }

}
