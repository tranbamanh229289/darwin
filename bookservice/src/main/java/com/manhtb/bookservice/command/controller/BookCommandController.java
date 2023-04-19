package com.manhtb.bookservice.command.controller;

import com.manhtb.bookservice.command.command.CreateBookCommand;
import com.manhtb.bookservice.command.command.DeleteBookCommand;
import com.manhtb.bookservice.command.command.UpdateBookCommand;
import com.manhtb.bookservice.model.request.BookRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
public class BookCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String create(@RequestBody BookRequest bookRequest) {
        CreateBookCommand createBookCommand = CreateBookCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .isReady(bookRequest.getIsReady())
                .build();

        commandGateway.sendAndWait(createBookCommand);
        return "add book";
    }

    @PutMapping
    public String update(@RequestBody BookRequest bookRequest) {
        UpdateBookCommand updateBookCommand = UpdateBookCommand.builder()
                .id(bookRequest.getId())
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .isReady(bookRequest.getIsReady())
                .build();
        commandGateway.sendAndWait(updateBookCommand);
        return "update book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        DeleteBookCommand deleteBookCommand = DeleteBookCommand.builder()
                .id(id)
                .build();
        commandGateway.sendAndWait(deleteBookCommand);
        return "delete book";
    }
}
