package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.Profil;
import com.teamyostrik.efrip.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api")
public class ProfilController {

    private final ProfileService profileService;

    @Autowired
    public ProfilController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(path = "/profil")
    public List<Profil> getAllProducts() {
        return profileService.getAllProfil();
    }

    @GetMapping("/profil/{id}")
    public Profil getProfileByUser(@PathVariable("id") String id) {
        return profileService.getProfil(id);
    }

    @PostMapping(path = "/profil")
    public void addProduct(@RequestBody Profil profil) {
        profileService.addProfil(profil);
    }

    @DeleteMapping(path = "/profil/{id}")
    public void deleteProfile(@PathVariable("id") String id) {
        profileService.deleteProfil(id);

    }

    @PutMapping(path = "/profil/{id}")
    public void updateProfile(@PathVariable("id") String id, @RequestBody Profil profil) {
        profileService.updateProfil(id, profil);
    }
    @PutMapping(path = "/profilad/{id}")
    public void updateProfileAdvence(@PathVariable("id") String id, @RequestBody Profil profil) {
        profileService.updateProfilAdvence(id, profil);
    }
}
