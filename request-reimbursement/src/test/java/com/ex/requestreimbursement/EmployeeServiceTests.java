package com.ex.requestreimbursement;

import com.ex.requestreimbursement.exceptions.EmployeeNotFoundException;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import com.ex.requestreimbursement.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void initEachTest() {
        System.out.println("Initialization before test");
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        EmployeeNotFoundException ex = Assertions.assertThrows(EmployeeNotFoundException.class, ()-> {
            employeeService.findById(0);
        });
        Assertions.assertEquals("Employee not found", ex.getMessage(), "Method did not throw exception with invalid employee id");
    }
}
