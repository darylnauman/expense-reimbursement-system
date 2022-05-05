package com.ex.requestreimbursement.models;

import lombok.*;

/**
 * Class for an object that will take in a managerId and their update on the status of a reimbursement request
 * These are used to carry out the update and the result will be reflected in the database
 * These individual actions are not persisted in the database table
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    private int managerId;
    private String type;
}
