package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.CartRepository;
import com.teamyostrik.efrip.repositories.ProductRepository;
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

    public List<Cart> getCart(User user) {
        return cartRepository.findAllByUser(user);
    }

    public void addToCart(Cart cartItem) {

        String id = this.cartRepository.save(cartItem).getId();
        updateQuantity(id, cartItem.getQuantity());
    }

    public void removeFromCart(String id) {
        this.cartRepository.deleteById(id);
    }

    //    public void updateQuantity(String type,String id, int quantity) {
//        Optional<Cart> itemToUpdate=cartRepository.findById(id);
//        itemToUpdate.ifPresent(cart -> {
//            Optional<Product> productToUpdate= productRepository.findById(cart.getProduct().getId());
//            productToUpdate.ifPresent(product -> {
//                if(type.equals("increment")){
//                    product.setQuantity(product.getQuantity()+quantity);
//
//                }else {
//                    product.setQuantity(product.getQuantity()-quantity);
//                }
//                productRepository.save(product);
//                cart.setQuantity(quantity);
//                cartRepository.save(cart);
//            });
//
//        });
//
//    }
    public void updateQuantity(String id, int quantity) {
        Optional<Cart> itemToUpdate = cartRepository.findById(id);
        itemToUpdate.ifPresent(cart -> {
            cart.setQuantity(quantity);
            cartRepository.save(cart);
        });
    }

    public Optional<Cart> findCartByProductAndUser_Id(Product product, User user) {
        return cartRepository.findByProductAndUser(product, user);
    }
}
