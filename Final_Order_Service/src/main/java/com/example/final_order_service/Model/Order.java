package com.example.final_order_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private Product product;
    private double price;
    private String address;
    private long phoneNo;
    private String paymentMode;
}
