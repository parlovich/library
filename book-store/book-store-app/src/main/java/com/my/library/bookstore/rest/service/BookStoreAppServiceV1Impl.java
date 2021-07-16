package com.my.library.bookstore.rest.service;

import com.my.library.bookstore.api.v1.BookStore;
import com.my.library.bookstore.api.v1.model.Book;
import com.my.library.bookstore.service.BookStoreService;
import com.my.library.bookstore.service.model.BookTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookStoreAppServiceV1Impl implements BookStore {

    @Autowired
    BookStoreService bookStoreService;

    @Autowired
    BookMapper bookMapper;

    @Override
    public Book addBook(Book book) {
        BookTO bookTO = bookMapper.toBookTO(book);
        return bookMapper.toBook(bookStoreService.addBook(bookTO));
    }

    @Override
    public Book findBook(UUID bookId) {
        return bookMapper.toBook(bookStoreService.findBook(bookId));
    }

}
