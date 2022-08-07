package com.example.cart_demo.Repository;

import com.example.cart_demo.Model.Cart;
import com.example.cart_demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public void save(Cart cart) {
        mongoTemplate.save(cart);
    }

    public Cart findById(int cartId) {
        return mongoTemplate.findById(cartId, Cart.class);
    }

    public long delete(Cart c) {
        return mongoTemplate.remove(c).getDeletedCount();
    }

    public List<Cart> getAll() {
        return mongoTemplate.findAll(Cart.class);
    }
}
