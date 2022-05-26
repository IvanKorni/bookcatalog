package com.library.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {

    @Autowired
    BookService bookService;

    @Test
    void getAll() {
        assertEquals(4, bookService.getAll().size());
    }

    @Test
    void getSortedStatistic() {
        assertTrue(bookService.getSortedStatistic().containsValue(2));
        assertFalse(bookService.getSortedStatistic().containsValue(3));
    }

    @Test
    void findByFirstLetter() {
        assertFalse(bookService.findByFirstLetter('a').isEmpty());
    }
}