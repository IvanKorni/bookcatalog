package com.library.springboot.controller;

import com.library.springboot.entity.Book;
import com.library.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> showAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/books/statistic")
    public Map<Character, Integer> getSortedStatistic() {
        return bookService.getSortedStatistic();
    }

    @GetMapping("/book/{latter}")
    public List<Book> getBook(@PathVariable char latter) {
        return bookService.findByFirstLetter(latter);
    }


}
