package com.example.order_template.Repository;

import com.example.order_template.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void find(Order order) {
        mongoTemplate.save(order);
    }
    public List<Order> listAll() {
        return mongoTemplate.findAll(Order.class);
    }
}
