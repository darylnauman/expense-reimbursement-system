package com.ex.requestreimbursement;

import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employees;

    public boolean saveEmployee(Employee newEmployee) {
        employees.save(newEmployee);
        return true;
    }

    public List<Employee> findAllEmployees() {
        return employees.findAll();
    }

    public Optional<Employee> findById(Integer id) {
        return employees.findById(id);
    }
}
