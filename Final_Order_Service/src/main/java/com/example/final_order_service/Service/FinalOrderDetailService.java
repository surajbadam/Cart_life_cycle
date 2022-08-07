package com.example.final_order_service.Service;

import com.example.final_order_service.Model.Order;
import com.example.final_order_service.Model.OrderDetails;
import com.example.final_order_service.Repository.FinalOrderRepository;
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
public class FinalOrderDetailService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    FinalOrderRepository finalOrderRepository;
    public List<Order> orderDeliveryItems(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Order> entity = new HttpEntity<Order>(headers);
        return restTemplate.exchange("http://localhost:9003/order", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Order>>() {
        }).getBody();
    }


    public void post(OrderDetails od) {
        finalOrderRepository.post(od);
    }

    public List<OrderDetails> getAllOrders() {
        return finalOrderRepository.getAllOrders();
    }
}
