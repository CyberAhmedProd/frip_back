package com.teamyostrik.efrip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.repositories.ProductRepository;

import java.util.List;

import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService (ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct (String id){
        return productRepository.findById(id);
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
    public boolean updateProduct(String id,Product product){
    	Optional<Product> productData = productRepository.findById(id);
    	if(productData.isPresent()) {
    		Product productUpdate = productData.get();
    		productUpdate.setName(product.getName());
    		productUpdate.setUser(product.getUser());
    		productUpdate.setCategory(product.getCategory());
    		productUpdate.setDetails(product.getDetails());
    		productUpdate.setPrice(product.getPrice());
    		productUpdate.setDescription(product.getDescription());
    		productUpdate.setFeatured(product.isFeatured());
    		productUpdate.setImage(product.getImage());
    		productUpdate.setImages(product.getImages());
            productRepository.save(productUpdate);
            return true;
        }
    	else
    		return false;

    }
}
