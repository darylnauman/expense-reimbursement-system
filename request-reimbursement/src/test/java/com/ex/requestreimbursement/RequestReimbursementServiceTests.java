package com.ex.requestreimbursement;

import com.ex.requestreimbursement.exceptions.RRNotFoundException;

import com.ex.requestreimbursement.repositories.ReimbursementRequestRepository;
import com.ex.requestreimbursement.services.ReimbursementRequestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestReimbursementServiceTests {

	@Autowired
	private ReimbursementRequestRepository requestRepository;

	@Autowired
	private ReimbursementRequestService reimbursementRequestService;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void initEachTest() {
		System.out.println("Initialization before test");
	}

	@Test
	public void shouldThrowRRNotFoundException() {
        RRNotFoundException ex = Assertions.assertThrows(RRNotFoundException.class, ()-> {
            reimbursementRequestService.findById(0);
        });
        Assertions.assertEquals("Reimbursement request not found", ex.getMessage(), "Method did not throw exception with invalid RR id");
	}
}

//		ReimbursementRequest rr1 = new ReimbursementRequest("chairs", 250, 1, 2);
//		reimbursementRequestService.saveReimbursementRequest(rr1);
//		System.out.println(reimbursementRequestService.findAllReimbursementRequests());