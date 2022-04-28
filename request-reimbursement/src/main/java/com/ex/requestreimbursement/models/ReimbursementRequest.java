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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String item;

    @Column(columnDefinition = "float")
    private float amount;

    @Column(columnDefinition = "varchar(45)")
    private String date;

    @Column(columnDefinition = "varchar(45) default managerReview")
    private String status;

    @Column(columnDefinition = "integer")
    private int employee_id;

    @Column(columnDefinition = "integer")
    private int manager_id;

}
