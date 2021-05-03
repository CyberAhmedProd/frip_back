package com.teamyostrik.efrip.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.teamyostrik.efrip.models.Address;
import com.teamyostrik.efrip.models.Photo;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.Profil;
import com.teamyostrik.efrip.models.Role;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.AddressRepository;
import com.teamyostrik.efrip.repositories.PhotoRepository;
import com.teamyostrik.efrip.repositories.ProductRepository;
import com.teamyostrik.efrip.repositories.ProfilRepository;
import com.teamyostrik.efrip.repositories.UserRepository;

@Service
public class ProfileService {
	@Autowired
	private ProfilRepository profilRepository;
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private UserRepository userRepository;
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
	    		profilUpdate.setFirstName(profil.getFirstName());
	    		profilUpdate.setLastName(profil.getLastName());
	    		profilUpdate.setUserState(profil.getUserState());
	    		profilUpdate.setAvatar(profil.getAvatar());
	    		Address addressUpdate = new Address();
	    		addressUpdate.setCity(profil.getAddress().getCity());
	    		addressUpdate.setCodePostal(profil.getAddress().getCodePostal());
	    		addressUpdate.setCountry(profil.getAddress().getCountry());
	    		addressUpdate.setStreet(profil.getAddress().getStreet());
	    		profilUpdate.setAddress(addressUpdate);
	    		User userUpdate = new User();
	    		userUpdate.setEmail(profil.getUser().getEmail());
	    		if(profil.getUser().getPassword().length() < 16) {
	    			userUpdate.setPassword(bCryptPasswordEncoder.encode(profil.getUser().getPassword()));
	    		}
	    		
	    		profilRepository.save(profilUpdate);
	    		return true;
	        }

	    	return false;

	    }
}
