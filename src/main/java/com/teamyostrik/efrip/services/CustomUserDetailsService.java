package com.teamyostrik.efrip.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamyostrik.efrip.models.Address;
import com.teamyostrik.efrip.models.Photo;
import com.teamyostrik.efrip.models.Profil;
import com.teamyostrik.efrip.models.Role;
import com.teamyostrik.efrip.models.Status;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.AddressRepository;
import com.teamyostrik.efrip.repositories.PhotoRepository;
import com.teamyostrik.efrip.repositories.ProfilRepository;
import com.teamyostrik.efrip.repositories.RoleRepository;
import com.teamyostrik.efrip.repositories.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private PhotoRepository photoRepository;

	
	public User findUserByEmail(String email) {
	    return userRepository.findByEmail(email);
	}
	
	public void saveUser(User user) {
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    user.setStatus(Status.pending);
	    Role userRole = roleRepository.findByRole(user.getRoles().iterator().next().getRole());
	    user.setRoles(new HashSet<>(Arrays.asList(userRole)));
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
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	    User user = userRepository.findByEmail(email);
	    if(user != null) {
	        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
	        return buildUserForAuthentication(user, authorities);
	    } else {
	        throw new UsernameNotFoundException("username not found");
	    }
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    userRoles.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getRole()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}