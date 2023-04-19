package com.manhtb.employeeservice.query.projection;

import com.manhtb.employeeservice.entity.Employee;
import com.manhtb.employeeservice.model.response.EmployeeResponse;
import com.manhtb.employeeservice.query.query.GetAllEmployeeQuery;
import com.manhtb.employeeservice.query.query.GetEmployeeQuery;
import com.manhtb.employeeservice.service.impl.EmployeeService;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {
    @Autowired
    private EmployeeService employeeService;

    @QueryHandler
    public EmployeeResponse handle(GetEmployeeQuery query) {
        Employee employee = employeeService.get(query.getId());
        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .kin(employee.getKin())
                .isDisciplined(employee.isDisciplined())
                .build();

        return employeeResponse;
    }

    @QueryHandler
    public List<EmployeeResponse> handle(GetAllEmployeeQuery query) {
        List<Employee> employeeList = employeeService.getAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employeeList.forEach(i -> {
            EmployeeResponse employeeResponse = EmployeeResponse.builder()
                    .id(i.getId())
                    .firstName(i.getFirstName())
                    .lastName(i.getLastName())
                    .kin(i.getKin())
                    .isDisciplined(i.isDisciplined())
                    .build();
            employeeResponseList.add(employeeResponse);
        });
        return employeeResponseList;
    }
}
