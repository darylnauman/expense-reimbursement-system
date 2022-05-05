package com.ex.requestreimbursement.models;

import lombok.*;
import javax.persistence.*;

/**
 * Model for a reimbursement request that is stored in the database
 * date is automatically created based on when the reimbursement is submitted
 * amount refers to the cost of the item to be reimbursed
 * managerId is the employeeId of the individual's manager
 */

@Entity
@Table(name="reimbursementrequest")
@Getter
@Setter
@ToString
@Builder
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

    public ReimbursementRequest() {
    }
    public ReimbursementRequest(int id, String item, float amount, String date, String status, int employeeId, int managerId) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.employeeId = employeeId;
        this.managerId = managerId;
    }

    public ReimbursementRequest(int id, String item, float amount, int employeeId, int managerId) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.date = "";
        this.status = "";
        this.employeeId = employeeId;
        this.managerId = managerId;
    }

    public ReimbursementRequest(String item, float amount, int employeeId, int managerId) {
//        this.id = id;
        this.item = item;
        this.amount = amount;
        this.date = "";
        this.status = "";
        this.employeeId = employeeId;
        this.managerId = managerId;
    }
}
