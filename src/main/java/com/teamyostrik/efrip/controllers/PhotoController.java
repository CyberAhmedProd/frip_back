package com.teamyostrik.efrip.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.teamyostrik.efrip.models.Photo;
import com.teamyostrik.efrip.services.PhotoService;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PhotoController {
	@Autowired
	private PhotoService photoService;
	@PostMapping("/photos/add")
	public ResponseEntity addPhoto(@RequestParam("title") String title,
	  @RequestParam("image") MultipartFile image)
	   {
		   String id = null;
		   try {
			   id = photoService.addPhoto(title, image);
			   HashMap <Object ,Object > model = new HashMap<Object,Object>();
			   model.put("success",1);
			   model.put("message","photo added successfully");
			   model.put("id",id);
			   return ok(model);
		   } catch (IOException e) {
			   HashMap <Object ,Object > model = new HashMap<Object,Object>();
			   model.put("success",0);
			   model.put("message",e.getMessage());
			   return ok(model);

		   }

	}
	@PutMapping("/photos/{id}")
	public ResponseEntity updatePhoto(@PathVariable("id") String id,@RequestParam("title") String title,
			  @RequestParam("image") MultipartFile image)
			   {
				   try {
					   String res = photoService.updatePhoto(id, title, image);
					   HashMap <Object ,Object > model = new HashMap<Object,Object>();
					   model.put("success",1);
					   model.put("message","photo added successfully");
					   model.put("id",res);
					   return ok(model);
				   } catch (IOException e) {
					   HashMap <Object ,Object > model = new HashMap<Object,Object>();
					   model.put("success",0);
					   model.put("message",e.getMessage());
					   return ok(model);

				   }

			}
	@GetMapping("/photos/{id}")
	public ResponseEntity getPhoto(@PathVariable String id, Model model) {
	    Photo photo = photoService.getPhoto(id);
	    model.addAttribute("title", photo.getTitle());
	    model.addAttribute("image", 
	      Base64.getEncoder().encodeToString(photo.getImage().getData()));
	    return new ResponseEntity(model,HttpStatus.OK);
	}
}
