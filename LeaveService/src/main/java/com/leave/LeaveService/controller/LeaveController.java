package com.leave.LeaveService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class LeaveController {


    @PostMapping("/leave/request")
    public ResponseEntity<String> leaveRequest() {


        return ResponseEntity.status(HttpStatus.CREATED).body("Leave applied successfully...");
    }

}
