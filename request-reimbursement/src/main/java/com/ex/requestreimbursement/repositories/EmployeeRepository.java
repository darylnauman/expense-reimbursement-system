package com.ex.requestreimbursement.repositories;

import com.ex.requestreimbursement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
