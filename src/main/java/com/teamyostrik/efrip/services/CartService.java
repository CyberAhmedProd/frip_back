package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
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
           cart.setQuantity(quantity);
        });

    }
    public Optional<Cart> findCartByProductAndUser_Id(Product product,String user_id){
        return cartRepository.findByProductAndUser_id(product,user_id);
    }
}
