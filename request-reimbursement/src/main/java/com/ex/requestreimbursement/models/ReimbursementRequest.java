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
    // @Column(name="id", columnDefinition = "AUTO_INCREMENT")
    private int id;

    private String item;
    private float amount;
    private String date;
    private String status;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "manager_id")
    private int managerId;

    public ReimbursementRequest(String item, float amount, int employeeId, int managerId) {
        this.item = item;
        this.amount = amount;
        this.employeeId = employeeId;
        this.managerId = managerId;
    }
}
