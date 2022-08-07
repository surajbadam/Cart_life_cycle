package com.example.cart_demo.Exception;

import lombok.Data;

@Data
public class ControllerException {
    private String errorCode;
    private String errorMessage;
    public ControllerException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public ControllerException(){

    }
}
