package com.example.final_order_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "OrderDetails")
public class OrderDetails {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private int oid;
    private Order order;
}
