package com.ex.requestreimbursement.repositories;

import com.ex.requestreimbursement.models.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for employee data
 */

@Qualifier("employees")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmail(@Param("email") String email);

}
