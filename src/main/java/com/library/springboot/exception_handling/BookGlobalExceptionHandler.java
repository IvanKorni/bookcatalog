package com.library.springboot.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BookIncorrectData> handlerException(
            NoSuchBookException exception) {
        BookIncorrectData bookIncorrectData = new BookIncorrectData();
        bookIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(bookIncorrectData, HttpStatus.NOT_FOUND);
    }
}
