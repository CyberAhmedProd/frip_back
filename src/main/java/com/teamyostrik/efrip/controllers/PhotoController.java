package com.teamyostrik.efrip.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.teamyostrik.efrip.services.PhotoService;
public class PhotoController {
	@Autowired
	private PhotoService PhotoService;
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("title") String title, 
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
	    String id = PhotoService.addPhoto(title, image);
	    return "redirect:/photos/" + id;
	}
}
