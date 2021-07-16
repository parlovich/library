package com.my.library.bookstore.rest.service;

import com.my.library.bookstore.api.v1.model.Book;
import com.my.library.bookstore.service.model.BookTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookTO toBookTO(Book book);

    Book toBook(BookTO bookTO);
}
