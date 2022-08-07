package com.example.cart_demo.Service;

import com.example.cart_demo.CartValidator.ValidateCart;
import com.example.cart_demo.Exception.CustomException;
import com.example.cart_demo.Model.Cart;
import com.example.cart_demo.Model.Product;
//import com.fasterxml.jackson.core.type.TypeReference;
import com.example.cart_demo.Repository.CartRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class CartService {
    @Autowired
    ValidateCart validateCart;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CartRepository cartRepository;
    public List<Product> getProducts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);
        return restTemplate.exchange("http://localhost:9001/product/", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Product>>() {
        }).getBody();
    }

    public void save(Cart cart){
    try{
        validateCart.validate(cart);
        cartRepository.save(cart);
    }
    catch (CustomException ce){
        throw new CustomException(HttpStatus.BAD_REQUEST.toString(), ce.getErrorMessage());
        }
    }

    public Cart findById(int cartId) {
        return cartRepository.findById(cartId);
    }

    public long delete(Cart c) {
        return cartRepository.delete(c);
    }

    public List<Cart> getAll() {
        return cartRepository.getAll();
    }
}
