package com.example.cart_demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private long id;
    private String name;
    private String description;
    private String imageLink;
    private double price;
    private int quantity;
}
