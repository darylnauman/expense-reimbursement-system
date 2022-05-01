package com.ex.requestreimbursement.repositories;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Qualifier("reimbursementrequests")
@Repository
public interface ReimbursementRequestRepository extends JpaRepository<ReimbursementRequest, Integer> {

    @Modifying
    @Query("update ReimbursementRequest r set r.manager_id = :manager_id where r.id = :id")
    void updateManager(@Param(value = "id") Integer id, @Param(value = "manager_id") Integer manager_id);
}
