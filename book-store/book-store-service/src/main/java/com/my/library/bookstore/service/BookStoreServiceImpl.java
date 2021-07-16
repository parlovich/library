package com.my.library.bookstore.service;

import com.my.library.bookstore.service.model.BookTO;
import com.my.library.bookstore.service.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BooksRepository repository;

    @Override
    public BookTO addBook(BookTO book) {
        book.setId(UUID.randomUUID());
        return repository.save(book);
    }

    @Override
    public BookTO findBook(UUID bookId) {
        return repository.findById(bookId).orElse(null);
    }
}
