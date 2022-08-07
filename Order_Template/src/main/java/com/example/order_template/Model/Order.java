package com.example.order_template.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Order")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private int id;
    private Product product;
    private double price;
    private String address;
    private long phoneNo;
    private String paymentMode;
}
