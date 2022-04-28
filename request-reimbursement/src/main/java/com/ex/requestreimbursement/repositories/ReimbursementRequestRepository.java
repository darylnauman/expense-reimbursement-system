package com.ex.requestreimbursement.repositories;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementRequestRepository extends JpaRepository<ReimbursementRequest, Integer> {

}
