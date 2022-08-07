package com.example.final_order_service.Controller;

import com.example.final_order_service.Exception.CustomException;
import com.example.final_order_service.Model.Order;
import com.example.final_order_service.Model.OrderDetails;
import com.example.final_order_service.Service.FinalOrderDetailService;
import com.example.final_order_service.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class OrderDetailsController {
    @Autowired
    private SequenceGeneratorService service;
    @Autowired
    FinalOrderDetailService finalOrderDetailService;
    @Autowired
    MongoTemplate mongoTemplate;
    @GetMapping("/{orderId}")
    public void deliveryCheck(@PathVariable int orderId){
            for(Order order:finalOrderDetailService.orderDeliveryItems()){
                if(orderId==order.getId()){
                    OrderDetails od=new OrderDetails();
                    od.setOid(service.getSequenceNumber(OrderDetails.SEQUENCE_NAME));
                    if(order.getPaymentMode().equals("COD")&&!order.getAddress().equals(null)&&order.getPhoneNo()!=0){
                        od.setOrder(order);
                        finalOrderDetailService.post(od);
                    }

                }
                else {
                    throw new CustomException(HttpStatus.BAD_REQUEST.toString(),"invalid details provided");
                }
        }
    }
    @GetMapping
    public List<OrderDetails> getAllOrders(){
        return finalOrderDetailService.getAllOrders();
    }
}
