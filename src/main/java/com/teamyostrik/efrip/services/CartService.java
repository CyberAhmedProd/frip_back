package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.repositories.CartRepository;
import com.teamyostrik.efrip.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<Cart> getCart(String user_id){
        return cartRepository.findAllByUser_id(user_id);
    }

    public void addToCart(Cart cartItem){
        this.cartRepository.save(cartItem);
    }
    public void removeFromCart(String id){
        this.cartRepository.deleteById(id);
    }

    public void updateQuantity(String id, int quantity) {
        Optional<Cart> itemToUpdate=cartRepository.findById(id);
        itemToUpdate.ifPresent(cart -> {
            Optional<Product> productToUpdate= productRepository.findById(cart.getProduct().getId());
           cart.setQuantity(quantity);
        });

    }
    public Optional<Cart> findCartByProductAndUser_Id(Product product,String user_id){
        return cartRepository.findByProductAndUser_id(product,user_id);
    }
}
