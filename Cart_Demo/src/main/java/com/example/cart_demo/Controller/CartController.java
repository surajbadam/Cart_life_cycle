package com.example.cart_demo.Controller;

import com.example.cart_demo.CartValidator.ValidateCart;
import com.example.cart_demo.Exception.ControllerException;
import com.example.cart_demo.Exception.CustomException;
import com.example.cart_demo.Model.Cart;
import com.example.cart_demo.Model.Product;
import com.example.cart_demo.Service.CartService;
import com.example.cart_demo.Service.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ValidateCart validateCart;
    @Autowired
    private SequenceGeneratorService service;
    @Autowired
    CartService cartService;

    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @GetMapping("/{id}")
    public void saveToCart(@PathVariable long id, @RequestParam("quantity") int quantity) {
        for(Product product:cartService.getProducts()){
            try {
                if (id == product.getId()) {
                    Cart c = new Cart();
                    product.setQuantity(quantity);
                    //product.setPrice(product.getPrice()*quantity);
                    c.setAmount(product.getPrice() * quantity);
                    c.setCartId(service.getSequenceNumber(Cart.SEQUENCE_NAME));
                    c.setProduct(product);
                    validateCart.validate(c);
                    cartService.save(c);
                }
            }
            catch (CustomException ce){
                ControllerException e=new ControllerException(ce.getErrorCode(),ce.getErrorMessage());
            }
        }
    }
    @DeleteMapping("/{cartId}")
    public long deleteItemFromCart(@PathVariable int cartId){
        Cart c=cartService.findById(cartId);
        return cartService.delete(c);
    }
    @GetMapping
    public List<Cart> getAllProducts(){
        return cartService.getAll();
    }
}
