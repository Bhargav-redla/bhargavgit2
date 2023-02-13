package com.slokam.book.ourexception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;

@RestControllerAdvice
public class ourExceptionhandler {
	
	
	  @ExceptionHandler(Exception.class) ResponseEntity<String>
	  handleException(Exception e){ ResponseEntity<String> re=new
	 ResponseEntity<>("Gotexception",HttpStatus.INTERNAL_SERVER_ERROR);
	  return re;
	  }
	 
  @ExceptionHandler(NotFoundException.class)
  ResponseEntity<String> handleException(NotFoundException e){
    ResponseEntity<String> re=new ResponseEntity<>("notfoundexception",HttpStatus.INTERNAL_SERVER_ERROR);
    return re;
    }

}
