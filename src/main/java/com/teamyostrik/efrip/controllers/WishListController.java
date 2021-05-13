package com.teamyostrik.efrip.controllers;


import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.models.WishList;
import com.teamyostrik.efrip.services.UserService;
import com.teamyostrik.efrip.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/wishlist")
public class WishListController {
    private final WishListService wishListService;
    private final UserService userService;

    @Autowired
    public WishListController(WishListService wishListService, UserService userService) {
        this.wishListService = wishListService;
        this.userService = userService;
    }

    @PostMapping(path = "{user_id}")
    public List<WishList> getWishList(@PathVariable("user_id") String user_id) {
        Optional<User> user = userService.getUser(user_id);
        return user.map(wishListService::getWishList).orElse(null);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<HashMap<Object, Object>> addToWishList(@RequestBody WishList wishListItem) {
        Optional<WishList> toCheck = wishListService.findWishListByProductAndUser(wishListItem.getProduct(), wishListItem.getUser());
        HashMap<Object, Object> model = new HashMap<>();
        if (toCheck.isPresent()) {
            model.put("success", 0);
            model.put("message", "item already in wishlist");
        } else {
            model.put("success", 1);
            model.put("message", "item added successfully");
            wishListService.addToWishList(wishListItem);
        }
        return ResponseEntity.ok(model);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteFromCart(@PathVariable("id") String id){
        wishListService.deleteFromWishList(id);
    }
}
