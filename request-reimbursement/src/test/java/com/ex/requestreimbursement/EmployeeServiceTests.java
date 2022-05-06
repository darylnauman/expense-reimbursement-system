package com.ex.requestreimbursement;

import com.ex.requestreimbursement.exceptions.EmployeeNotFoundException;
import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.repositories.EmployeeRepository;
import com.ex.requestreimbursement.services.EmployeeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
    public void shouldReturnEmployeeById() {
        newEmployee = Employee.builder()
                .firstName("Tim").lastName("Thompson")
                .email("tim@company.com").password("asdfgh")
                .department("Accounting").title("Accountant")
                .employeeLevel(2).managerId(2).build();

        // Add an employee temporarily to repository
        Employee savedEmployee = employeeService.saveEmployee(newEmployee);

        // Get id of recently saved employee and then run findById
        int id = savedEmployee.getId();
        Optional<Employee> searchedEmployee = employeeService.findById(id);

        // Check employee returned by findById matches expected values
        Assertions.assertNotNull(searchedEmployee);
        Assertions.assertEquals(savedEmployee.getEmail(), "tim@company.com", "Employee returned does not have matching email");
        Assertions.assertEquals(savedEmployee.getLastName(), "Thompson", "Employee returned does not have matching last name");

        employeeService.deleteEmployee(employees.findByEmail("tim@company.com").getId());
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

    @Test
    public void shouldReturnNotNullFindAllEmployees() {
        Assertions.assertNotNull(employeeService.findAllEmployees());
    }

    @Test
    public void shouldSuccessfullyDeleteEmployee() {
        newEmployee = Employee.builder()
                .firstName("Tim").lastName("Thompson")
                .email("tim@company.com").password("asdfgh")
                .department("Accounting").title("Accountant")
                .employeeLevel(2).managerId(2).build();

        // Add employee temporarily to repository
        Employee savedEmployee = employeeService.saveEmployee(newEmployee);

        // Get id of recently saved employee and then run findById
        int id = savedEmployee.getId();

        Assertions.assertTrue(employeeService.deleteEmployee(id));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionOnDelete() {
        EmployeeNotFoundException ex = Assertions.assertThrows(EmployeeNotFoundException.class, ()-> {
            employeeService.deleteEmployee(-1);
        });
        Assertions.assertEquals("No employee with this id found to delete", ex.getMessage(), "Method did not throw when trying to delete an employee with invalid id");
    }
}
