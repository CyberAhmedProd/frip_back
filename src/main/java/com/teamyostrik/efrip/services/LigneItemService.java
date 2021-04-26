package com.teamyostrik.efrip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teamyostrik.efrip.models.LigneItem;
import com.teamyostrik.efrip.repositories.LigneItemRepository;
@Service
public class LigneItemService {
	@Autowired
	private LigneItemRepository ligneItemRepository;
	
	 public List<LigneItem> getAllLigneItem () {
	        return ligneItemRepository.findAll();
	    }

	    public Optional<LigneItem> getProduct (String id){
	        return ligneItemRepository.findById(id);
	    }
	    public void addProduct(LigneItem ligneItem){
	    	ligneItemRepository.save(ligneItem);
	    }
	    public void deleteProduct(String id){
	    	ligneItemRepository.deleteById(id);
	    }
}
