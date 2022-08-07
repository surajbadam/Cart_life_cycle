package com.example.final_order_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private String description;
    private String imageLink;
    private double price;
    private int quantity;
}
