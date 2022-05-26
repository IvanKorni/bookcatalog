package com.library.springboot.util;

import com.library.springboot.dao.BookDao;
import com.library.springboot.entity.Book;


import java.util.stream.Stream;

public class StreamFilter {
    public static Stream<Book> stream(BookDao bookDao, char letter) {
        return bookDao.findAll().stream().filter(book -> book.getAuthor().toLowerCase().charAt(0) == letter);
    }
}