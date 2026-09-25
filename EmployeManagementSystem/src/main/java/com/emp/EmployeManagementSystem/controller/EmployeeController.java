package com.emp.EmployeManagementSystem.controller;

import com.emp.EmployeManagementSystem.EmployeeDTO;
import com.emp.EmployeManagementSystem.Service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employee)
    {

        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created successfully");
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id)
    {

        EmployeeDTO response=employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



}
