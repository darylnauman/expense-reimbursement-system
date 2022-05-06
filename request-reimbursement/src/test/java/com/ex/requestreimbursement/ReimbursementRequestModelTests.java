package com.ex.requestreimbursement;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReimbursementRequestModelTests {

    ReimbursementRequest newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(1).build();

    @BeforeEach
    public void initEachTest() {
        System.out.println("Initialization before test");
    }

    @Test
    public void shouldSetRRDate() {
        newRR.setDate("2022-05-05");
        Assertions.assertEquals("2022-05-05", newRR.getDate());
    }

    @Test
    public void shouldSetRRStatus() {
        newRR.setStatus("approved");
        Assertions.assertEquals("approved", newRR.getStatus());
    }

    @Test
    public void shouldSetRRemployeeId() {
        newRR.setEmployeeId(1);
        Assertions.assertEquals(1, newRR.getEmployeeId());
    }
}
