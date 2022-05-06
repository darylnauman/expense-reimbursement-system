package com.ex.requestreimbursement;

import com.ex.requestreimbursement.models.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeModelTests {

     Employee newEmployee = Employee.builder()
                .firstName("Tim").lastName("Thompson")
                .email("tim@company.com").password("asdfgh")
                .department("Accounting").title("Accountant")
                .employeeLevel(2).managerId(2).build();

    @BeforeEach
    public void initEachTest() {
        System.out.println("Initialization before test");
    }

    @Test
    public void shouldSetFirstName() {
        newEmployee.setFirstName("Frank");
        Assertions.assertEquals("Frank", newEmployee.getFirstName());
    }

    @Test
    public void shouldSetPassword() {
        newEmployee.setPassword("12345");
        Assertions.assertEquals("12345", newEmployee.getPassword());
    }

    @Test
    public void shouldSetDepartment() {
        newEmployee.setDepartment("Legal");
        Assertions.assertEquals("Legal", newEmployee.getDepartment());
    }

    @Test
    public void shouldSetEmployeeLevel() {
        newEmployee.setEmployeeLevel(3);
        Assertions.assertEquals(3, newEmployee.getEmployeeLevel());
    }

    @Test
    public void shouldSetManagerId() {
        newEmployee.setManagerId(3);
        Assertions.assertEquals(3, newEmployee.getManagerId());
    }

    @Test
    public void shouldSetTitle() {
        newEmployee.setTitle("Accountant");
        Assertions.assertEquals("Accountant", newEmployee.getTitle());
    }

}
