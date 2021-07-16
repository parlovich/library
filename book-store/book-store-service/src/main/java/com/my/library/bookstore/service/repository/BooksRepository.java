package com.my.library.bookstore.service.repository;

import com.my.library.bookstore.service.model.BookTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BooksRepository extends CrudRepository<BookTO, UUID> {
}
