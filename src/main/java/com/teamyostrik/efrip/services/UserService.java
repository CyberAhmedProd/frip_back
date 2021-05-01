package com.teamyostrik.efrip.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamyostrik.efrip.models.Role;
import com.teamyostrik.efrip.models.Status;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.RoleRepository;
import com.teamyostrik.efrip.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public Optional<User> getUser (String id){
        return userRepository.findById(id);
    }
    public void addUser(User user){
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
 	    Role userRole = roleRepository.findByRole(user.getRoles().iterator().next().getRole());
 	    if(userRole != null) {
 	    	 user.setRoles(new HashSet<>(Arrays.asList(userRole)));
 	    }
 	    else {
 	    	Role roleData = roleRepository.save(user.getRoles().iterator().next());
 	    	user.setRoles(new HashSet<>(Arrays.asList(roleRepository.save(roleData))));
 	    }
    	userRepository.save(user);
    }
    public void deleteUser(String id){
    	userRepository.deleteById(id);
    }
   
}
