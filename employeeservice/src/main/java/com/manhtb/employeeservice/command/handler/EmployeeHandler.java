package com.manhtb.employeeservice.command.handler;

import com.manhtb.employeeservice.command.event.EmployeeCreatedEvent;
import com.manhtb.employeeservice.command.event.EmployeeDeletedEvent;
import com.manhtb.employeeservice.command.event.EmployeeUpdatedEvent;
import com.manhtb.employeeservice.service.impl.EmployeeService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;

    @EventHandler
    public void handle(EmployeeCreatedEvent event) {
        employeeService.save(event);
    }

    @EventHandler
    public void handle(EmployeeUpdatedEvent event) {
        employeeService.save(event);
    }

    @EventHandler
    public void handle(EmployeeDeletedEvent event) {
        employeeService.delete(event);
    }
}
