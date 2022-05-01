package com.ex.requestreimbursement.repositories;

import com.ex.requestreimbursement.models.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("employees")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
