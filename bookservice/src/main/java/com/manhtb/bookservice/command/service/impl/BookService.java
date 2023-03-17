package com.manhtb.bookservice.command.service.impl;

import com.manhtb.bookservice.command.entity.Book;
import com.manhtb.bookservice.command.event.BookCreatedEvent;
import com.manhtb.bookservice.command.event.BookDeletedEvent;
import com.manhtb.bookservice.command.event.BookUpdatedEvent;
import com.manhtb.bookservice.command.model.request.BookRequest;
import com.manhtb.bookservice.command.repository.IBookRepository;
import com.manhtb.bookservice.command.service.IBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Book save(BookCreatedEvent bookCreatedEvent) {
        Book book = mapper.map(bookCreatedEvent, Book.class);
        return bookRepository.save(book);
    }

    @Override
    public Book save(BookUpdatedEvent bookUpdatedEvent) {
        Book book = mapper.map(bookUpdatedEvent, Book.class);
        return bookRepository.save(book);
    }

    @Override
    public void delete(BookDeletedEvent bookDeletedEvent) {
        bookRepository.deleteById(bookDeletedEvent.getId());
    }
}
