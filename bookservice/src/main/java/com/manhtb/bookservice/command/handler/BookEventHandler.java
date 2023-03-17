package com.manhtb.bookservice.command.handler;

import com.manhtb.bookservice.command.event.BookCreatedEvent;
import com.manhtb.bookservice.command.event.BookDeletedEvent;
import com.manhtb.bookservice.command.event.BookUpdatedEvent;
import com.manhtb.bookservice.command.service.IBookService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandler {
    @Autowired
    private IBookService bookService;

    @EventHandler
    public void onCreate(BookCreatedEvent event) {
        bookService.save(event);
    }

    @EventHandler
    public void onUpdate(BookUpdatedEvent event) {
        bookService.save(event);
    }

    @EventHandler
    public void onDelete(BookDeletedEvent event) {
        bookService.delete(event);
    }
}
