package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.ProductRepository;
import com.teamyostrik.efrip.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final PhotoService photoService;
    private final UserRepository userRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, PhotoService photoService,UserRepository userRepository) {
        this.productRepository = productRepository;
        this.photoService = photoService;
        this.userRepository = userRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getAllByUser(User user) {
        return productRepository.findAllByUser(user);
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(String id, Product product) {
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
            Product productUpdate = productData.get();
            productUpdate.setName(product.getName());
            productUpdate.setUser(product.getUser());
            productUpdate.setCategory(product.getCategory());
            productUpdate.setDetails(product.getDetails());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setQuantity(product.getQuantity());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setFeatured(product.isFeatured());
            productUpdate.setImages(product.getImages());
            productRepository.save(productUpdate);
        }

    }
    public int countProduct() {
    	return (int)productRepository.count();
    }
   
}
