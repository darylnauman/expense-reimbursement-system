package com.ex.requestreimbursement;

import com.ex.requestreimbursement.exceptions.EmployeeNotFoundException;
import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import com.ex.requestreimbursement.services.EmployeeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeRepository employees;

    @Autowired
    private EmployeeService employeeService;

    Employee newEmployee;

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

    @Test
    public void shouldReturnNewEmployee() {
        newEmployee = Employee.builder()
                .firstName("Tim").lastName("Thompson")
                .email("tim@company.com").password("asdfgh")
                .department("Accounting").title("Accountant")
                .employeeLevel(2).managerId(2).build();

        Employee savedEmployee = employeeService.saveEmployee(newEmployee);

        Assertions.assertNotNull(savedEmployee);
        Assertions.assertEquals(newEmployee.getEmail(), savedEmployee.getEmail(), "email does not match");

        employeeService.deleteEmployee(employees.findByEmail("tim@company.com").getId());
    }
}
