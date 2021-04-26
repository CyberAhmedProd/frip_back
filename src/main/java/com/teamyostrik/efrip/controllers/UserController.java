package com.teamyostrik.efrip.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "api/user")
public class UserController {
	@Autowired
	private UserService userService;
    @GetMapping
    public List<User> getAllProducts(){
        return userService.getAllUsers();
    }
    @GetMapping(path ="{id}")
    public Optional<User> getProductById(@PathVariable ("id") String id){
        return userService.getUser(id);
    }
    @PostMapping
    public void addProduct(@RequestBody User user) {
    	userService.addUser(user);
    }
    @DeleteMapping(path = "{productid}")
    public void deleteProduct(@PathVariable ("productid") String id ){
    	userService.deleteUser(id);
    }

}
