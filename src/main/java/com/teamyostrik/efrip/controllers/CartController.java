package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.services.CartService;
import com.teamyostrik.efrip.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping
    public List<Cart> getCart(@RequestBody String user_id) {
        Optional<User> user = userService.getUser(user_id);
        return user.map(cartService::getCart).orElse(null);

    }

    @PostMapping(path = "/add")
    public ResponseEntity<HashMap<Object, Object>> addToCart(@RequestBody Cart cartItem) {
        Optional<Cart> toCheck = cartService.findCartByProductAndUser_Id(cartItem.getProduct(), cartItem.getUser());
        HashMap<Object, Object> model = new HashMap<>();
        if (toCheck.isPresent()) {
            model.put("success", 0);
            model.put("message", "item already in cart");
        } else {
            model.put("success", 1);
            model.put("message", "item added successfully");
            cartService.addToCart(cartItem);
        }
        return ResponseEntity.ok(model);

    }

    @PutMapping(path = "/update/quantity/{id}")
    public void updateQuantity(@PathVariable("id") String id, @RequestBody int quantity) {
        cartService.updateQuantity(id, quantity);
    }
}
