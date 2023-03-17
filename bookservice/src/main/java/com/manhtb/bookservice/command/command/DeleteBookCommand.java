package com.manhtb.bookservice.command.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DeleteBookCommand {
    @TargetAggregateIdentifier
    private String id;
}
