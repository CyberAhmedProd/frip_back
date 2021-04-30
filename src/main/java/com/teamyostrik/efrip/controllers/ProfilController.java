package com.teamyostrik.efrip.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teamyostrik.efrip.models.Profil;

import com.teamyostrik.efrip.services.ProfileService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "api")
public class ProfilController {
	 @Autowired
	 private ProfileService profileService;
	 @GetMapping(path = "/profil")
	 public List<Profil> getAllProducts(){
		 return profileService.getAllProfil();
	 }
	 @GetMapping(path ="/profil/{id}")
	 public Profil getProfilByUser(@PathVariable("id") String id){
	     return profileService.getProfil(id);
	 }
	 @PostMapping(path = "/profil")
	 public void addProduct(@RequestBody Profil profil) {
		 profileService.addProfil(profil);
	 }
	 @DeleteMapping(path = "/profil/{id}")
	 public void deleteProduct(@PathVariable ("id") String id ){
		 profileService.deleteProfil(id);;
	 }
	 @PutMapping(path = "/profil/{id}")
	 public void updateProduct(@PathVariable ("id") String id, @RequestBody Profil profil){
		 profileService.updateProfil(id, profil);
	 }
}
