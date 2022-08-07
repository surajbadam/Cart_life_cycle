package com.example.final_order_service.Exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public CustomException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public CustomException(){

    }
}
