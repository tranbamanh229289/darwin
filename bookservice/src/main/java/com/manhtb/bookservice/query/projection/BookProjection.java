package com.manhtb.bookservice.query.projection;

import com.manhtb.bookservice.entity.Book;
import com.manhtb.bookservice.model.response.BookResponse;
import com.manhtb.bookservice.query.query.GetAllBookQuery;
import com.manhtb.bookservice.query.query.GetBookQuery;
import com.manhtb.bookservice.service.IBookService;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {
    @Autowired
    private IBookService bookService;

    @QueryHandler
    public BookResponse getBook(GetBookQuery getBookQuery) {
        Book book = bookService.get(getBookQuery.getId());
        BookResponse bookResponse = BookResponse.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .isReady(book.getIsReady())
                .build();
        return bookResponse;
    }

    @QueryHandler
    public List<BookResponse> getAllBook(GetAllBookQuery getAllBookQuery) {
        List<Book> bookList = bookService.getAll();
        List<BookResponse> bookResponseList = new ArrayList<>();
        bookList.forEach(item -> {
            BookResponse bookResponse = new BookResponse();
            bookResponse = bookResponse.builder()
                    .id(item.getId())
                    .isReady(item.getIsReady())
                    .author(item.getAuthor())
                    .name(item.getName())
                    .build();
            bookResponseList.add(bookResponse);

        });
        return bookResponseList;
    }
}
