package com.ex.requestreimbursement.controllers;

import com.ex.requestreimbursement.services.EmployeeService;
import com.ex.requestreimbursement.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee newEmployee) {
        logger.info("EmployeeController - POST mapping for createEmployee");
        try {
          boolean success = employeeService.saveEmployee(newEmployee);

          if (success) {
              return ResponseEntity.ok("New employee created");
          } else {
              return ResponseEntity.internalServerError().body("Error creating new employee");
          }
        } catch (Exception e) {
            logger.warn("EmployeeController - catch block for create new employee");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error creating new employee");
        }
    }

    @GetMapping
    public ResponseEntity getAllEmployees() {
        logger.info("EmployeeController - GET mapping for getAllEmployees");
        try {
            List<Employee> employees = employeeService.findAllEmployees();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            logger.warn("EmployeeController - catch block for getAllEmployees");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error getting all employees");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getEmployeeById(@PathVariable Integer id) {
        logger.info("EmployeeController - GET mapping for getEmployeeById");
        try {
            Optional<Employee> employee = employeeService.findById(id);

            if (employee.isPresent()) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            logger.warn("EmployeeController - catch block for getEmployeeById");
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}