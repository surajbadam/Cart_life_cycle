package com.example.cart_demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "database_sequences")
@Component
public class DatabaseSequence {
    @Id
    private String  id;
    private int seq;
}
