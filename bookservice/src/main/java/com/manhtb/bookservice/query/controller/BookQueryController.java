package com.manhtb.bookservice.query.controller;

import com.manhtb.bookservice.model.response.BookResponse;
import com.manhtb.bookservice.query.query.GetAllBookQuery;
import com.manhtb.bookservice.query.query.GetBookQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable String id) {
        GetBookQuery getBookQuery = new GetBookQuery();
        getBookQuery.setId(id);
        BookResponse bookResponse = queryGateway.query(getBookQuery, ResponseTypes.instanceOf(BookResponse.class)).join();
        return bookResponse;
    }

    @GetMapping
    public List<BookResponse> getAllBook() {
        GetAllBookQuery getAllBookQuery = new GetAllBookQuery();
        List<BookResponse> bookResponseList = queryGateway.query(getAllBookQuery, ResponseTypes.multipleInstancesOf(BookResponse.class)).join();
        return bookResponseList;
    }
}
