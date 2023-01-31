package com.example.demo.exceptions;

public class EmailExistException extends Exception{
    public EmailExistException(String message) {
        super(message);
    }
}
