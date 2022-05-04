package com.ex.requestreimbursement;

import com.ex.requestreimbursement.exceptions.RRNotFoundException;

import com.ex.requestreimbursement.models.Employee;
import com.ex.requestreimbursement.models.ReimbursementRequest;
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
	private ReimbursementRequestRepository reimbursementRequests;

	@Autowired
	private ReimbursementRequestService reimbursementRequestService;

	ReimbursementRequest newRR;

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

	@Test
	public void shouldReturnNewRR() {
		newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(0).build();

		ReimbursementRequest savedRR = reimbursementRequestService.saveReimbursementRequest(newRR);

		Assertions.assertNotNull(savedRR);
		Assertions.assertEquals(newRR.getItem(), savedRR.getItem(), "item does not match");
		Assertions.assertEquals(newRR.getAmount(), savedRR.getAmount(), "amount does not match");

		reimbursementRequestService.deleteReimbursementRequest(savedRR.getId());
	}


}

//		ReimbursementRequest rr1 = new ReimbursementRequest("chairs", 250, 1, 2);
//		reimbursementRequestService.saveReimbursementRequest(rr1);
//		System.out.println(reimbursementRequestService.findAllReimbursementRequests());