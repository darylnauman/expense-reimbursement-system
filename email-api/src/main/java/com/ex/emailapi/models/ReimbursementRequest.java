package com.ex.emailapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// import javax.persistence.Column;

@Getter
@Setter
@ToString
public class ReimbursementRequest {
    private int id;
    private String item;
    private float amount;
    private String date;
    private String status;
    private int employeeId;
    private int managerId;
}
