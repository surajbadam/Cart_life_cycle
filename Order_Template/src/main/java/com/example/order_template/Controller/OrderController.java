package com.example.order_template.Controller;

import com.example.order_template.Model.Cart;
import com.example.order_template.Model.Order;
import com.example.order_template.Service.OrderService;
import com.example.order_template.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    OrderService orderService;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/{cartId}")
    public void checkout(@PathVariable int cartId, @RequestParam("address") String address, @RequestParam("phoneNo") long phoneNo, @RequestParam("paymentMode") String paymentMode){
        for(Cart cart:orderService.getCartItems()){
            if(cartId==cart.getCartId()){
                Order order=new Order();
                order.setId(sequenceGeneratorService.getSequenceNumber(Order.SEQUENCE_NAME));
                order.setProduct(cart.getProduct());
                order.setAddress(address);
                order.setPhoneNo(phoneNo);
                order.setPaymentMode(paymentMode);
                //order.setPrice(cart.getProduct().getPrice());
                order.setPrice(cart.getAmount());
                orderService.find(order);
            }
        }
    }
    @GetMapping
    public List<Order> getAllCheckoutItems(){
        return orderService.listAll();
    }
}
