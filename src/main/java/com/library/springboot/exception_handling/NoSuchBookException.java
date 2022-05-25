package com.library.springboot.exception_handling;

public class NoSuchBookException extends RuntimeException{

    public NoSuchBookException(String message) {
        super(message);
    }
}
