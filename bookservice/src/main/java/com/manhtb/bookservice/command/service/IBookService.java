package com.manhtb.bookservice.command.service;

import com.manhtb.bookservice.command.entity.Book;
import com.manhtb.bookservice.command.event.BookCreatedEvent;
import com.manhtb.bookservice.command.event.BookDeletedEvent;
import com.manhtb.bookservice.command.event.BookUpdatedEvent;
import com.manhtb.bookservice.command.model.request.BookRequest;

public interface IBookService {
    Book save(BookCreatedEvent bookCreatedEvent);
    Book save(BookUpdatedEvent bookUpdatedEvent);

    void delete(BookDeletedEvent bookDeletedEvent);
}
