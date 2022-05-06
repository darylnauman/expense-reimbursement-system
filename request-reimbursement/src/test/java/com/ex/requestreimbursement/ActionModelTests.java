package com.ex.requestreimbursement;

import com.ex.requestreimbursement.models.Action;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionModelTests {

    Action action = Action.builder().managerId(1).type("managerReview").build();

    @BeforeEach
    public void initEachTest() {
        System.out.println("Initialization before test");
    }

    @Test
    public void shouldSetStatus() {
        action.setType("approved");
        Assertions.assertEquals("approved", action.getType());
    }

    @Test
    public void shouldSetManagerId() {
        action.setManagerId(2);
        Assertions.assertEquals(2, action.getManagerId());
    }
}
