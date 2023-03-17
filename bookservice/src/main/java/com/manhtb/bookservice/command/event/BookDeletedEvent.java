package com.manhtb.bookservice.command.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDeletedEvent {
    private String id;
}
