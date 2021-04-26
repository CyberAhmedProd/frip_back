package com.teamyostrik.efrip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public Optional<User> getUser (String id){
        return userRepository.findById(id);
    }
    public void addUser(User user){
    	userRepository.save(user);
    }
    public void deleteUser(String id){
    	userRepository.deleteById(id);
    }
   
}
