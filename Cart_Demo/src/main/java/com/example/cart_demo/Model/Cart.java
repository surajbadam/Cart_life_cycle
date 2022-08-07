package com.example.cart_demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Cart")
public class Cart {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private int cartId;
    private Product product;

    private double amount;

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
