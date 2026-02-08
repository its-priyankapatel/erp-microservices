package com.erp.user_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(IncompleteData.class)
    public ResponseEntity<Map<String,String>>handleIncompleteData(IncompleteData e)
    {
        Map<String,String> response=new LinkedHashMap<>();
        response.put("success","false");
        response.put("message",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
