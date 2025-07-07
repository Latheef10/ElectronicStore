package com.prsw.electro.store.ElectronicStore.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@Builder

public class APIResponse <T>{

    private LocalDate timeStamp;

    private HttpStatus status;

    private String message;


    private T data;
}
