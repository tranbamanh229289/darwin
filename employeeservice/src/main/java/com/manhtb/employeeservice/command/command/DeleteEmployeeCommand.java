package com.manhtb.employeeservice.command.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Getter
@Setter
public class DeleteEmployeeCommand {
    @TargetAggregateIdentifier
    private String id;
}
