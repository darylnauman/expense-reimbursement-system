package com.ex.requestreimbursement.models;

import lombok.*;
import javax.persistence.*;

/**
 * Class for an employee that is stored in the database
 * employeeLevel provides a means to ensure a request is approved by an appropriate employee within the
 * organization - CEO has a level of 0 and should be able to approve anyone of level 1, 2, etc. An employee
 * at level 1 should only be able to have reimbursements approved by an employee at the 0 level.
 */

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;
    private String department;
    private String title;

    @Column(name="employee_level")
    private int employeeLevel;

    @Column(name="manager_id")
    private int managerId;
}
