package com.example.final_order_service.Repository;

import com.example.final_order_service.Model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FinalOrderRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public void post(OrderDetails od) {
        mongoTemplate.save(od);
    }

    public List<OrderDetails> getAllOrders() {
        return mongoTemplate.findAll(OrderDetails.class);
    }
}
