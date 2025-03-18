package com.learning.ex_productservice.Exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExcpetionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", ex.getMessage());
//        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
//        body.put("timestamp", LocalDateTime.now());
//        body.put("path", request.getDescription(false).replace("uri=",""));
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
//    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException e, WebRequest request) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", e.getMessage());
//        body.put("status", HttpStatus.NOT_FOUND);
//        body.put("timestamp", LocalDateTime.now());
//        body.put("path", request.getDescription(false).replace("uri=",""));
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("message", e.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
//    }
}
