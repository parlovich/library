package com.my.library.bookstore.service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.my.library.bookstore.service"})
@EnableJpaRepositories({"com.my.library.bookstore.service.repository"})
@EntityScan({"com.my.library.bookstore.service.model"})
public class BookStoreServiceConfig {
}