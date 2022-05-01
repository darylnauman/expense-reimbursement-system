package com.ex.requestreimbursement.controllers;

import com.ex.requestreimbursement.services.EmployeeService;
import com.ex.requestreimbursement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee newEmployee) {
        try {
          boolean success = employeeService.saveEmployee(newEmployee);

          if (success) {
              return ResponseEntity.ok("New employee created");
          } else {
              return ResponseEntity.internalServerError().body("Error saving new employee");
          }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error saving new employee");
        }
    }

    @GetMapping
    public ResponseEntity getAllEmployees() {
        try {
            List<Employee> employees = employeeService.findAllEmployees();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error getting all employees");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getEmployeeById(@PathVariable Integer id) {
        try {
            Optional<Employee> employee = employeeService.findById(id);

            if (employee.isPresent()) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}