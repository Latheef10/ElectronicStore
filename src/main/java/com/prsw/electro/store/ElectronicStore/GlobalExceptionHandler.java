package com.prsw.electro.store.ElectronicStore;

import com.prsw.electro.store.ElectronicStore.exceptions.UserNotFoundEXception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundEXception.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundEXception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
