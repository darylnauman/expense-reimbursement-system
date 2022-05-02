package com.ex.requestreimbursement.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", employeeId=" + employeeId +
                ", managerId=" + managerId +
                '}';
    }
}
