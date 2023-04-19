package com.manhtb.employeeservice.query.controller;

import com.manhtb.employeeservice.model.response.EmployeeResponse;
import com.manhtb.employeeservice.query.query.GetAllEmployeeQuery;
import com.manhtb.employeeservice.query.query.GetEmployeeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeQueryController {
    @Autowired
    private QueryGateway queryGateway;


    @GetMapping("/{id}")
    public EmployeeResponse get(@PathVariable String id) {
        GetEmployeeQuery getEmployeeQuery = new GetEmployeeQuery();
        getEmployeeQuery.setId(id);
        EmployeeResponse employeeResponse = queryGateway.query(getEmployeeQuery, ResponseTypes.instanceOf(EmployeeResponse.class)).join();
        return employeeResponse;
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        GetAllEmployeeQuery getAllEmployeeQuery = new GetAllEmployeeQuery();
        List<EmployeeResponse> employeeResponseList = queryGateway.query(getAllEmployeeQuery, ResponseTypes.multipleInstancesOf(EmployeeResponse.class)).join();
        return employeeResponseList;
    }

}
