package com.manhtb.employeeservice.service.impl;

import com.manhtb.employeeservice.command.event.EmployeeCreatedEvent;
import com.manhtb.employeeservice.command.event.EmployeeDeletedEvent;
import com.manhtb.employeeservice.command.event.EmployeeUpdatedEvent;
import com.manhtb.employeeservice.entity.Employee;
import com.manhtb.employeeservice.repository.IEmployeeRepository;
import com.manhtb.employeeservice.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Employee save(EmployeeCreatedEvent event) {
        Employee employee = modelMapper.map(event, Employee.class);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee save(EmployeeUpdatedEvent event) {
        Employee employee = modelMapper.map(event, Employee.class);
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(EmployeeDeletedEvent event) {
        employeeRepository.deleteById(event.getId());
    }

    @Override
    public Employee get(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

}
