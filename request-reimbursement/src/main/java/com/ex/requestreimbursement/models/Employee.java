package com.ex.requestreimbursement.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
    private int manager_id;
}
