package com.prsw.electro.store.ElectronicStore.exceptions;

import com.prsw.electro.store.ElectronicStore.Responses.APIResponse;
import com.prsw.electro.store.ElectronicStore.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserNotFoundEXception extends RuntimeException{


    public UserNotFoundEXception(String s) {
        super(s);
    }

    public ResponseEntity<APIResponse<Object>> UserNotFoundEXception(String s) {

        APIResponse<Object> response = APIResponse.builder()
                .timeStamp(LocalDate.from(LocalDateTime.now()))
                .status(HttpStatus.NOT_FOUND)
                .message(s)
                .data(null)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
