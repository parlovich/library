package com.my.library.bookstore.rest.controller;

import com.my.library.bookstore.api.v1.BookStore;
import com.my.library.bookstore.api.v1.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path="/api/v1/books")
public class BookStoreControllerV1 {

    @Autowired
    BookStore bookStore;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookStore.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{guid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("guid") UUID id) {
        Book book = bookStore.findBook(id);
        if (book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
