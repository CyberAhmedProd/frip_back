package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "api/user")
public class UserController {
	@Autowired
	private UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path ="{id}")
    public Optional<User> getUserById(@PathVariable ("id") String id){
        return userService.getUser(id);
    }
    @PostMapping
    public void addUser(@RequestBody User user) {
    	userService.addUser(user);
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") String id ){
    	userService.deleteUser(id);
    	return new ResponseEntity<String>("ok",HttpStatus.OK);
    }
    @PutMapping(path = "{id}")
	 public void updateUser(@PathVariable ("id") String id, @RequestBody User user){
    	userService.updateUser(id,user);
	 }
    @PutMapping(path = "/simple/{id}")
	 public void simpleUpdateUser(@PathVariable ("id") String id, @RequestBody User user){
   	userService.simpleUpdateUser(id,user);
	 }

}
