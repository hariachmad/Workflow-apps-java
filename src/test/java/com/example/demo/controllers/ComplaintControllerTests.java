package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.entities.Complaint;
import com.example.demo.models.repos.ComplaintRepo;
import com.example.demo.services.ComplaintService;

@SpringBootTest
public class ComplaintControllerTests {
    
    @Mock
    private ComplaintRepo complaintRepo;

    @InjectMocks
    private ComplaintService complaintService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave(){
        Complaint complaint = new Complaint();
        complaint.setId(99);
        complaint.setTitle("Mock Title");

        when(complaintRepo.findById(1)).thenReturn(Optional.of(complaint));

        Complaint result = complaintService.findOne(1);
        assertNotNull(result);
        assertEquals("Mock Title", result.getTitle());
    }

    @Test
    public void testFindOne(){
        Complaint complaint = new Complaint();
        complaint.setId(99);
        complaint.setTitle("Mock Title");

        when(complaintRepo.save(complaint)).thenReturn(complaint);
        Complaint result = complaintService.save(complaint);
        assertNotNull(result);
        assertEquals("Mock Title", result.getTitle());
    }
}
