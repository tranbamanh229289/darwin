package com.manhtb.employeeservice.service;

import com.manhtb.employeeservice.command.event.EmployeeCreatedEvent;
import com.manhtb.employeeservice.command.event.EmployeeDeletedEvent;
import com.manhtb.employeeservice.command.event.EmployeeUpdatedEvent;
import com.manhtb.employeeservice.entity.Employee;
import com.manhtb.employeeservice.query.query.GetEmployeeQuery;

import java.util.List;

public interface IEmployeeService {
    public Employee save(EmployeeCreatedEvent event);

    public Employee save(EmployeeUpdatedEvent event);

    public void delete(EmployeeDeletedEvent event);

    public Employee get(String id);

    public List<Employee> getAll();
}
