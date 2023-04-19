package com.manhtb.bookservice.command.handler;

import com.manhtb.bookservice.command.event.BookCreatedEvent;
import com.manhtb.bookservice.command.event.BookDeletedEvent;
import com.manhtb.bookservice.command.event.BookUpdatedEvent;
import com.manhtb.bookservice.service.IBookService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandler {
    @Autowired
    private IBookService bookService;

    @EventHandler
    public void handle(BookCreatedEvent event) {
        bookService.save(event);
    }

    @EventHandler
    public void handle(BookUpdatedEvent event) {
        bookService.save(event);
    }

    @EventHandler
    public void handle(BookDeletedEvent event) {
        bookService.delete(event);
    }
}
