package com.manhtb.bookservice.service;

import com.manhtb.bookservice.entity.Book;
import com.manhtb.bookservice.command.event.BookCreatedEvent;
import com.manhtb.bookservice.command.event.BookDeletedEvent;
import com.manhtb.bookservice.command.event.BookUpdatedEvent;
import com.manhtb.bookservice.query.controller.BookQueryController;

import java.util.List;

public interface IBookService {
    Book save(BookCreatedEvent bookCreatedEvent);
    Book save(BookUpdatedEvent bookUpdatedEvent);

    void delete(BookDeletedEvent bookDeletedEvent);
    Book get(String id);
    List<Book> getAll();
}
