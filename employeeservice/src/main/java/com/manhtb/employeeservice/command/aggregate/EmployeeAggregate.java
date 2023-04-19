package com.manhtb.employeeservice.command.aggregate;

import com.manhtb.employeeservice.command.command.CreateEmployeeCommand;
import com.manhtb.employeeservice.command.command.DeleteEmployeeCommand;
import com.manhtb.employeeservice.command.command.UpdateEmployeeCommand;
import com.manhtb.employeeservice.command.event.EmployeeCreatedEvent;
import com.manhtb.employeeservice.command.event.EmployeeDeletedEvent;
import com.manhtb.employeeservice.command.event.EmployeeUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class EmployeeAggregate {
    @AggregateIdentifier
    private String id;
    private String firstName;
    private String lastName;
    private String kin;
    private boolean isDisciplined;

    public EmployeeAggregate() {

    }

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command) {
        EmployeeCreatedEvent event = EmployeeCreatedEvent.builder()
                .id(command.getId())
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .kin(command.getKin())
                .isDisciplined(command.isDisciplined())
                .build();
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand command) {
        EmployeeUpdatedEvent event = EmployeeUpdatedEvent.builder()
                .id(command.getId())
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .kin(command.getKin())
                .isDisciplined(command.isDisciplined())
                .build();
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteEmployeeCommand command) {
        EmployeeDeletedEvent event = EmployeeDeletedEvent.builder()
                .id(command.getId())
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void handleAggregate(EmployeeCreatedEvent event) {
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.isDisciplined();
    }
    @EventSourcingHandler
    public void handleAggregate(EmployeeUpdatedEvent event) {
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.kin = event.getKin();
        this.isDisciplined = event.isDisciplined();
    }
    @EventSourcingHandler
    public void handleAggregate(EmployeeDeletedEvent event) {
        this.id = event.getId();
    }
}
