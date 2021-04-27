package com.teamyostrik.efrip.controllers;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamyostrik.efrip.configs.JwtTokenProvider;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.UserRepository;
import com.teamyostrik.efrip.services.CustomUserDetailsService;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	UserRepository users;
	@Autowired
	private CustomUserDetailsService userService;
	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthBody data) {
		try {
			String email = data.getEmail();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));
			String token = jwtTokenProvider.createToken(email, this.users.findByEmail(email).getRoles());
			User userData = users.findByEmail(email);
			userData.setToken(token);
			return ok(userData);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user) {
		User userExists = userService.findUserByEmail(user.getEmail());
		User usernameExists = userRepository.findByUsername(user.getUsername());
		if (userExists != null) {
			return new ResponseEntity<>(0,HttpStatus.FOUND);
		}
		else if(usernameExists != null) {
			return new ResponseEntity<>(1,HttpStatus.FOUND);
		}
		else {
			userService.saveUser(user);
			Map<Object, Object> model = new HashMap<>();
			model.put("message", "User registered successfully");
			return ok(model);
		}
		
	}
}