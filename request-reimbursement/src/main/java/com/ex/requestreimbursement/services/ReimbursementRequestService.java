package com.ex.requestreimbursement.services;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import com.ex.requestreimbursement.repositories.ReimbursementRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReimbursementRequestService {

    @Autowired
    private ReimbursementRequestRepository reimbursementRequests;

    public boolean saveReimbursementRequest(ReimbursementRequest newReimbursementRequest) {
        newReimbursementRequest.setStatus("managerReview");
        LocalDate date = LocalDate.now();
        newReimbursementRequest.setDate(String.valueOf(date));
        reimbursementRequests.save(newReimbursementRequest);
        return true;
    }

    public List<ReimbursementRequest> findAllReimbursementRequests() {
        return reimbursementRequests.findAll();
    }

    public Optional<ReimbursementRequest> findById(Integer id) {
        return reimbursementRequests.findById(id);
    }

    public void reassignReimbursementRequest(Integer id, Integer revisedManagerId) {
        int manager_id = revisedManagerId;
        reimbursementRequests.updateManager(id, manager_id);
    }

    public boolean deleteReimbursementRequest(Integer id) {
        reimbursementRequests.deleteById(id);
        return true;
    }
}
