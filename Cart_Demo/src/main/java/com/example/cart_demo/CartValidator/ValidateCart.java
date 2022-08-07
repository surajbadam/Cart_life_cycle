package com.example.cart_demo.CartValidator;

import com.example.cart_demo.Exception.CustomException;
import com.example.cart_demo.Model.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidateCart {
    public void validate(Cart c){
        if(Objects.isNull(c)){
            throw new CustomException(HttpStatus.BAD_REQUEST.toString(),"please insert product into cart");
        } else if (Objects.isNull(c.getProduct())) {
            throw new CustomException(HttpStatus.BAD_REQUEST.toString(), "please insert product");
        } else if (c.getAmount()<=0) {
            throw new CustomException(HttpStatus.BAD_REQUEST.toString(), "Amount of product can't be zero");
        }
        else {
            throw new CustomException(HttpStatus.BAD_REQUEST.toString(), "please insert a valid product to cart");
        }
    }
}
