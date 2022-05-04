package com.ex.requestreimbursement.models;

import lombok.*;

import javax.persistence.*;

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
