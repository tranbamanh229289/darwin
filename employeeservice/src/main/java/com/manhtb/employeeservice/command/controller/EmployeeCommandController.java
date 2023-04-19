package com.manhtb.employeeservice.command.controller;

import com.manhtb.employeeservice.command.command.CreateEmployeeCommand;
import com.manhtb.employeeservice.command.command.DeleteEmployeeCommand;
import com.manhtb.employeeservice.command.command.UpdateEmployeeCommand;
import com.manhtb.employeeservice.model.request.EmployeeRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String create(@RequestBody EmployeeRequest employeeRequest) {
        CreateEmployeeCommand command = CreateEmployeeCommand.builder()
                .id(UUID.randomUUID().toString())
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .kin(employeeRequest.getKin())
                .isDisciplined(false)
                .build();
        commandGateway.sendAndWait(command);
        return "add employee";
    }

    @PutMapping
    public String update(@RequestBody EmployeeRequest employeeRequest) {
        UpdateEmployeeCommand command = UpdateEmployeeCommand.builder()
                .id(employeeRequest.getId())
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .kin(employeeRequest.getKin())
                .isDisciplined(employeeRequest.isDisciplined())
                .build();
        commandGateway.sendAndWait(command);
        return "update employee";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        DeleteEmployeeCommand command = DeleteEmployeeCommand.builder()
                .id(id)
                .build();

        commandGateway.sendAndWait(command);
        return "delete employee";
    }
}
