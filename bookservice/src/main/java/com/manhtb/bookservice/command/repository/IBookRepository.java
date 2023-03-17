package com.manhtb.bookservice.command.repository;

import com.manhtb.bookservice.command.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, String> {
}
