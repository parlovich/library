package com.my.library.bookstore.config;

import com.my.library.bookstore.service.config.BookStoreServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.my.library.bookstore.service.config.BookStoreServiceConfig.class})
public class BookStoreAppConfig {
}