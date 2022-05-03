package com.ex.requestreimbursement.services;

import com.ex.requestreimbursement.exceptions.EmployeeNotFoundException;
import com.ex.requestreimbursement.exceptions.RRNotFoundException;
import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employees;

    public boolean saveEmployee(Employee newEmployee) {
        employees.save(newEmployee);
        return true;
    }

    public List<Employee> findAllEmployees() {
        return employees.findAll();
    }

    public Optional<Employee> findById(Integer id) throws EmployeeNotFoundException {
        Optional<Employee> employee = employees.findById(id);

        if (employee.isPresent()) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }
}
