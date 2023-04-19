package com.manhtb.bookservice.command.aggrerate;

import com.manhtb.bookservice.command.command.CreateBookCommand;
import com.manhtb.bookservice.command.command.DeleteBookCommand;
import com.manhtb.bookservice.command.command.UpdateBookCommand;
import com.manhtb.bookservice.command.event.BookCreatedEvent;
import com.manhtb.bookservice.command.event.BookDeletedEvent;
import com.manhtb.bookservice.command.event.BookUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class BookAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String author;
    private Boolean isReady;

    public BookAggregate() {

    }

    @CommandHandler
    public BookAggregate(CreateBookCommand createBookCommand) {
        BookCreatedEvent bookCreatedEvent = BookCreatedEvent.builder()
                .id(createBookCommand.getId())
                .name(createBookCommand.getName())
                .author(createBookCommand.getAuthor())
                .isReady(createBookCommand.getIsReady())
                .build();
        AggregateLifecycle.apply(bookCreatedEvent);
    }

    @CommandHandler
    public void handle(UpdateBookCommand updateBookCommand) {
        BookUpdatedEvent bookUpdatedEvent = BookUpdatedEvent.builder()
                .id(updateBookCommand.getId())
                .name(updateBookCommand.getName())
                .author(updateBookCommand.getAuthor())
                .isReady(updateBookCommand.getIsReady())
                .build();
        AggregateLifecycle.apply(bookUpdatedEvent);
    }

    @CommandHandler
    public void handle(DeleteBookCommand deleteBookCommand) {
        BookDeletedEvent bookDeletedEvent = BookDeletedEvent.builder()
                .id(deleteBookCommand.getId())
                .build();
        AggregateLifecycle.apply(bookDeletedEvent);
    }

    @EventSourcingHandler
    public void handleAggregate(BookCreatedEvent event) {
        this.id = event.getId();
        this.author = event.getAuthor();
        this.name = event.getName();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void hhandleAggregate(BookUpdatedEvent event) {
        this.id = event.getId();
        this.author = event.getAuthor();
        this.name = event.getName();
        this.isReady = event.getIsReady();
    }

    @EventSourcingHandler
    public void handleAggregate(BookDeletedEvent event) {
        this.id = event.getId();
    }
}
