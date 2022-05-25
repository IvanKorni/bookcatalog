package com.library.springboot.service;

import com.library.springboot.dao.BookDao;
import com.library.springboot.entity.Book;
import com.library.springboot.exception_handling.NoSuchBookException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


import static com.library.springboot.util.StreamFilter.stream;

@Service
@Log
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAll() {
        log.info("Getting a list of books");
        return bookDao.findAll();
    }

    @Override
    public Map<Character, Integer> getSortedStatistic() {
        log.info("Getting statistics");
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, 0);
            int count = (int) stream(bookDao, i).count();
            if (count != 0) {
                map.put(i, count);
            }
        }

        return map;
    }

    @Override
    public List<Book> findByFirstLetter(char letter) {
        log.info("Search for books by author");

        if (stream(bookDao, letter).count() == 0) {
            throw new NoSuchBookException("Book not found");
        }

        return stream(bookDao, letter).collect(Collectors.toList());
    }
}
