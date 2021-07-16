package com.my.library.bookstore.service;

import com.my.library.bookstore.service.model.BookTO;

import java.util.UUID;

public interface BookStoreService {
    BookTO addBook(BookTO book);

    BookTO findBook(UUID bookId);
}
