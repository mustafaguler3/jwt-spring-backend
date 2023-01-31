package com.example.demo.exceptions;

public class UsernameExistException extends Exception{
    public UsernameExistException(String message) {
        super(message);
    }
}
