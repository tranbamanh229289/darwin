package com.manhtb.employeeservice.query.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeQuery {
    private String id;
    private String firstName;
    private String lastName;
    private String kin;
    private boolean isDisciplined;
}
