package com.library.springboot.service;

import com.library.springboot.dao.BookDao;
import com.library.springboot.entity.Book;
import com.library.springboot.exception_handling.NoSuchBookException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static com.library.springboot.util.StreamFilter.stream;

@Service
@Transactional(readOnly = true)
@Log
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Cacheable(cacheNames="books")
    @Override
    public List<Book> getAll() {
        log.info("Getting a list of books");
        return bookDao.findAll();
    }

    @Cacheable(cacheNames="sorted_book")
    @Override
    public Map<Character, Integer> getSortedStatistic() {
        log.info("Getting statistics");
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char i = 'a'; i <= 'z'; i++) {
            int count = (int) stream(bookDao, i).count();
            map.put(i, count);
        }

        return map;
    }

    @Cacheable(cacheNames="find_books")
    @Override
    public List<Book> findByFirstLetter(char letter) {
        log.info("Search for books by author");

        Stream<Book> stream = stream(bookDao, letter);

        if (stream.count() == 0) {
            throw new NoSuchBookException("Book not found");
        }

        return stream.collect(Collectors.toList());
    }
}
