package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/cart" )
public class CartController {
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value ="/{user_id}")
    public List<Cart> getCart(@PathVariable("user_id") String user_id){
        return cartService.getCart(user_id);
    }

    @PostMapping(value="/add")
    public ResponseEntity<HashMap<Object, Object>> addToCart(@RequestBody Cart cartItem){
        Optional<Cart> toCheck=cartService.findCartByProductAndUser_Id(cartItem.getProduct(), cartItem.getUser_id());
        HashMap<Object, Object> model=new HashMap<>();
        if(toCheck.isPresent()){
            model.put("success",0);
            model.put("message","item already in cart");
        } else {
            model.put("success",1);
            model.put("message","item added successfully");
            cartService.addToCart(cartItem);
        }
        return ResponseEntity.ok(model);

    }
}
