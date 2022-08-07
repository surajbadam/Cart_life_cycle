package com.example.order_template.Service;

import com.example.order_template.Model.Cart;
import com.example.order_template.Model.Order;
import com.example.order_template.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private OrderRepository orderRepository;


    public List<Cart> getCartItems(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Cart> entity = new HttpEntity<Cart>(headers);
        return restTemplate.exchange("http://localhost:9002/cart", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Cart>>() {
        }).getBody();
    }

    public void find(Order order) {
        orderRepository.find(order);
    }
    public List<Order> listAll() {
        return orderRepository.listAll();
    }
}
