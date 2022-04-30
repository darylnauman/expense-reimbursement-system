package com.ex.requestreimbursement.controllers;

import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employees;

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody Employee newEmployee) {
        try {
            employees.save(newEmployee);
            return ResponseEntity.ok("New employee created");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving new employee");
        }
    }

    @GetMapping("/employees")
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok(employees.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employees.findById(id);

        if(employee.isPresent()) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }

}
