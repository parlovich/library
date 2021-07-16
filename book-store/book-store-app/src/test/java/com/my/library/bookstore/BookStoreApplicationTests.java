package com.my.library.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = BookStoreApplication.class)
@AutoConfigureMockMvc
class BookStoreApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void testContext() {
		assertNotNull(context);
		assertTrue(true);
	}

}
