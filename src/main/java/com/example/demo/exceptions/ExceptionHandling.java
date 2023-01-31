package com.example.demo.exceptions;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.domain.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.NoResultException;

@RestControllerAdvice
public class ExceptionHandling {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static final String ACCOUNT_LOCKED = "Your account has been locked.Please contact administration";
    private static final String METHOD_IS_NOT_ALLOWED="This request method is not allowed on this endpoint";
    private static final String INTERNAL_SERVER_ERROR_MSG="An error occurred while processing the request";
    private static final String INCORRECT_CREDENTIALS="Username / Password incorrect";
    private static final String ACCOUNT_DISABLED="Your account has been disabled, if this is an error,contact " +
            "administraction";
    private static final String ERROR_PROCCESSING_FILE="Error occurred while processing file";
    private static final String NOT_ENOUGH_PERMISSION="You dont have enough permission";

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<HttpResponse> emailExistException(NoResultException exception){
        return createHttpResponse(HttpStatus.NOT_FOUND,exception.getMessage());
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<HttpResponse> accountDisabledException(){
        return createHttpResponse(HttpStatus.BAD_REQUEST,ACCOUNT_DISABLED);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<HttpResponse> tokenExpiredException(TokenExpiredException exception){
        return createHttpResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<HttpResponse> usernameExistException(UsernameExistException exception){
        return createHttpResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<HttpResponse> emailExistException(EmailExistException exception){
        return createHttpResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
    }

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus status,String message){
        return new ResponseEntity<>(new HttpResponse(status.value(),status,status.getReasonPhrase(),
                message.toUpperCase()),status);
    }
}



















