package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.*;
import com.teamyostrik.efrip.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private AddressRepository addressRepository;

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
    	
    	Profil profilData = new Profil();
    	profilData.setFirstName("foulen");
    	profilData.setLastName("BenFoulen");
    	Photo img = new Photo();
    	img.setTitle("image/png");
    	//String file  = "aa";
    	//img.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
    	profilData.setAvatar(photoRepository.save(img));	
    	Address address = new Address();
    	address.setCity(" ");
    	address.setCodePostal((short) 0000);
    	address.setCountry(" ");
    	address.setStreet(" ");
    	profilData.setAddress(addressRepository.save(address));
    	profilData.setUser(userRepository.save(user));
    	profilRepository.save(profilData);
    }
    public void deleteUser(String id){
    	Optional<User> userData = userRepository.findById(id);
    	profilRepository.deleteByUser(userData.get());
    	userRepository.deleteById(id);
    }
    public User updateUser(String id,User user){
    	Optional<User> userData = userRepository.findById(id);
    	if(userData.isPresent()) {
    		User userUpdate = userData.get();
    		if(user.getEmail() != null) {
    			userUpdate.setEmail(user.getEmail());
    		}
    		if(user.getUsername() != null) {
    			userUpdate.setUsername(user.getUsername());
    		}
    		
    		if(user.getPassword() != null) {
    			if(user.getPassword().length() <= 17)
    				userUpdate.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    		}
    		
    		
    		return userRepository.save(userUpdate);
        }
    	return null;

    }
}
