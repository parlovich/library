package com.my.library.bookstore.api.v1;

import com.my.library.bookstore.api.v1.model.Book;

import java.util.UUID;

public interface BookStore {
    Book addBook(Book book);

    Book findBook(UUID bookId);
}
