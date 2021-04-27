package com.teamyostrik.efrip.controllers;

public class PhotoController {
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("title") String title, 
	  @RequestParam("image") MultipartFile image, Model model) 
	  throws IOException {
	    String id = photoService.addPhoto(title, image);
	    return "redirect:/photos/" + id;
	}
}
