package com.ex.requestreimbursement;

import com.ex.requestreimbursement.exceptions.RRNotFoundException;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.repositories.ReimbursementRequestRepository;
import com.ex.requestreimbursement.services.ReimbursementRequestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
	public void shouldThrowRRNotFoundExceptionFindById() {
        RRNotFoundException ex = Assertions.assertThrows(RRNotFoundException.class, ()-> {
            reimbursementRequestService.findById(0);
        });
        Assertions.assertEquals("Reimbursement request not found", ex.getMessage(), "Method did not throw exception with invalid RR id");
	}

	@Test
	public void shouldReturnNewRR() {
		newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(1).build();

		ReimbursementRequest savedRR = reimbursementRequestService.saveReimbursementRequest(newRR);

		Assertions.assertNotNull(savedRR);
		Assertions.assertEquals(newRR.getItem(), savedRR.getItem(), "item does not match");
		Assertions.assertEquals(newRR.getAmount(), savedRR.getAmount(), "amount does not match");

		reimbursementRequestService.deleteReimbursementRequest(savedRR.getId());
	}

	@Test
	public void shouldReturnNonNullListRequestsByManagerId() {
		// Ensure at least one item in requests is assigned to manager being tested
		newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(1).build();
		ReimbursementRequest savedRR = reimbursementRequestService.saveReimbursementRequest(newRR);

		List<ReimbursementRequest> requests = reimbursementRequestService.findAllReimbursementRequestsByManagerId(1);

		Assertions.assertTrue(requests.size() > 0);
		reimbursementRequestService.deleteReimbursementRequest(savedRR.getId());
	}

	@Test
	public void shouldReturnNonNullListRequestsByEmployeeId() {
		// Ensure at least one item in requests is submitted by employee being tested
		newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(1).build();
		ReimbursementRequest savedRR = reimbursementRequestService.saveReimbursementRequest(newRR);

		List<ReimbursementRequest> requests = reimbursementRequestService.findAllReimbursementRequestsByEmployeeId(2);

		Assertions.assertTrue(requests.size() > 0);
		reimbursementRequestService.deleteReimbursementRequest(savedRR.getId());
	}

	@Test
	public void shouldReturnNonNullListRequestsFindAllReimbursementRequests() {
		// Ensure at least one item is in request repository
		newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(1).build();
		ReimbursementRequest savedRR = reimbursementRequestService.saveReimbursementRequest(newRR);

		List<ReimbursementRequest> requests = reimbursementRequestService.findAllReimbursementRequests();

		Assertions.assertTrue(requests.size() > 0);
		reimbursementRequestService.deleteReimbursementRequest(savedRR.getId());
	}

	@Test
	public void shouldReassign() {
		newRR = ReimbursementRequest.builder().item("speakers").amount(10).employeeId(2).managerId(1).build();

		ReimbursementRequest savedRR = reimbursementRequestService.saveReimbursementRequest(newRR);
		int id = savedRR.getId();

		reimbursementRequestService.reassignReimbursementRequest(id, 2);

		Optional<ReimbursementRequest> updatedRR;
		updatedRR = reimbursementRequestService.findById(id);

		Assertions.assertEquals(2, updatedRR.get().getManagerId(), "Item was not correctly reassigned to another employee");

		reimbursementRequestService.deleteReimbursementRequest(savedRR.getId());
	}

}