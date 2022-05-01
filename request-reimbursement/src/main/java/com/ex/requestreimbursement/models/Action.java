package com.ex.requestreimbursement.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    private int managerId;
    private String type;
}
