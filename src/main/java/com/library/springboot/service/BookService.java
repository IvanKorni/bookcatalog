package com.library.springboot.service;

import com.library.springboot.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> getAll();

    Map<Character, Integer> getSortedStatistic();

    List<Book> findByFirstLetter(char Letter);
}
