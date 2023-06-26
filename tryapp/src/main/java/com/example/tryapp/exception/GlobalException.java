package com.example.tryapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException
//        extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> notFoundException(NotFoundException notFoundException, WebRequest webRequest){
ErrorDetails errorDetails= new ErrorDetails(
                            LocalDateTime.now()
                            ,notFoundException.getMessage()
                            ,webRequest.getDescription(false),
                            "No Student Found");
 return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
}
