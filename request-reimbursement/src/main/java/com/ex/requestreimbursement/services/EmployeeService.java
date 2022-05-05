package com.ex.requestreimbursement.services;

import com.ex.requestreimbursement.exceptions.EmployeeNotFoundException;
import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer related to employees
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employees;

    public Employee saveEmployee(Employee newEmployee) {
        newEmployee = employees.save(newEmployee);
        return newEmployee;
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

    public boolean deleteEmployee(Integer id) {
        employees.deleteById(id);
        return true;
    }
}
