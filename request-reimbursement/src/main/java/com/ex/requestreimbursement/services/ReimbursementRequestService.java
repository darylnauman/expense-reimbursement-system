package com.ex.requestreimbursement.services;

import com.ex.requestreimbursement.exceptions.RRNotFoundException;
import com.ex.requestreimbursement.models.Action;
import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.repositories.ReimbursementRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class
ReimbursementRequestService {

    @Autowired
    private ReimbursementRequestRepository reimbursementRequests;

    public ReimbursementRequest saveReimbursementRequest(ReimbursementRequest newReimbursementRequest) {
        newReimbursementRequest.setStatus("managerReview");
        LocalDate date = LocalDate.now();
        newReimbursementRequest.setDate(String.valueOf(date));
        newReimbursementRequest = reimbursementRequests.save(newReimbursementRequest);
        return newReimbursementRequest;
    }

    public List<ReimbursementRequest> findAllReimbursementRequests() {
        return reimbursementRequests.findAll();
    }

    public Optional<ReimbursementRequest> findById(Integer id) throws RRNotFoundException {
        Optional<ReimbursementRequest> reimbursementRequest = reimbursementRequests.findById(id);

        if (reimbursementRequest.isPresent()) {
            return reimbursementRequest;
        } else {
            throw new RRNotFoundException("Reimbursement request not found");
        }
    }

    public void reassignReimbursementRequest(Integer id, Integer revisedManagerId) {
        int manager_id = revisedManagerId;
        reimbursementRequests.updateManager(id, manager_id);
    }

    public boolean deleteReimbursementRequest(Integer id) {
        reimbursementRequests.deleteById(id);
        return true;
    }

    public boolean updateStatus(Integer id, Action action) {
        reimbursementRequests.updateStatus(id, action.getType());
        return true;
    }

    public List<ReimbursementRequest> findAllReimbursementRequestsByManagerId(Integer managerId) {
        return reimbursementRequests.findAllByManagerId(managerId);
    }

    public List<ReimbursementRequest> findAllReimbursementRequestsByEmployeeId(Integer employeeId) {
        return reimbursementRequests.findAllByEmployeeId(employeeId);
    }
}
