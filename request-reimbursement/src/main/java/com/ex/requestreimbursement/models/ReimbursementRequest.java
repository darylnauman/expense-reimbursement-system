package com.ex.requestreimbursement.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="reimbursementrequest")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReimbursementRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    private int id;

    private String item;

    private float amount;

    private String date;

    private String status;

    private int employee_id;

    private int manager_id;
}
