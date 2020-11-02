package com.engine.fakau.springjwtsecurity.exception;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException(String mess) {
        super("Email already exist : "+ mess);
    }
}