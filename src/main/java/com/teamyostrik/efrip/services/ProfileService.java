package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Address;
import com.teamyostrik.efrip.models.Photo;
import com.teamyostrik.efrip.models.Profil;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.AddressRepository;
import com.teamyostrik.efrip.repositories.PhotoRepository;
import com.teamyostrik.efrip.repositories.ProfilRepository;
import com.teamyostrik.efrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;


	    public List<Profil> getAllProfil () {
	        return profilRepository.findAll();
	    }

	    public Profil getProfil (String id){
	    
	    	 Optional<User> userData = userRepository.findById(id);
	        return profilRepository.findByUser(userData.get()).get();
	    }
	    public void addProfil(Profil profil){
		    Optional<User> userData = userRepository.findById(profil.getUser().getId());
		    Optional<Photo> imageData = photoRepository.findById(profil.getAvatar().getId());
		    Address addressData = new Address();
		    addressData.setCity(profil.getAddress().getCity());
		    addressData.setCodePostal(profil.getAddress().getCodePostal());
		    addressData.setCountry(profil.getAddress().getCountry());
		    addressData.setStreet(profil.getAddress().getStreet());
		    profil.setAddress(addressRepository.save(addressData));
		    profil.setAvatar(imageData.get());
		    profil.setUser(userData.get());
		    
	    	profilRepository.save(profil);
	    }
	    public void deleteProfil(String id){
	    	profilRepository.deleteById(id);
	    }
	    public boolean updateProfil(String id,Profil profil){
	    	Optional<Profil> profilData = profilRepository.findById(id);
	    	if(profilData.isPresent()) {
	    		Profil profilUpdate = profilData.get();
	    		if(profil.getFirstName() != null)
	    			profilUpdate.setFirstName(profil.getFirstName());
	    		if(profil.getLastName() != null)
	    			profilUpdate.setLastName(profil.getLastName());
	    		if(profil.getUser().getId() != null) {
	    			Optional<User> userData = userRepository.findById(profil.getUser().getId());
	    			if(userData.isPresent()) {
	    				User userUpdate = userData.get();
	    				if(profil.getUser().getUsername() != null)
	    					userUpdate.setUsername(profil.getUser().getUsername());
	    				if(profil.getUser().getEmail() != null)
	    					userUpdate.setEmail(profil.getUser().getEmail());
	    				profilUpdate.setUser(userRepository.save(userUpdate));
	    			}
	    		}
	    		if(profil.getAddress().getId() != null) {
	    			Optional<Address> addressData = addressRepository.findById(profil.getAddress().getId());
	    			if(addressData.isPresent()) {
	    				Address addressUpdate = addressData.get();
	    				if(profil.getAddress().getCity()!= null)
	    					addressUpdate.setCity(profil.getAddress().getCity());
	    				if(profil.getAddress().getCodePostal() != null)
	    					addressUpdate.setCodePostal(profil.getAddress().getCodePostal());
	    				if(profil.getAddress().getCountry()!= null)
	    					addressUpdate.setCountry(profil.getAddress().getCountry());
	    				if(profil.getAddress().getStreet() != null)
	    					addressUpdate.setStreet(profil.getAddress().getStreet());
	    				profilUpdate.setAddress(addressRepository.save(addressUpdate));
	    			}
	    		}
	    		profilRepository.save(profilUpdate);
	    		return true;
	        }

	    	return false;

	    }
}
