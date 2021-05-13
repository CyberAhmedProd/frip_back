package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.models.WishList;
import com.teamyostrik.efrip.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListService {
    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishListService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }
    public List<WishList> getWishList(User user){
        return this.wishlistRepository.findAllByUser(user);
    }
    public void addToWishList(WishList wishListItem){
        this.wishlistRepository.save(wishListItem);
    }

    public void deleteFromWishList(String id){
        this.wishlistRepository.deleteById(id);
    }

    public Optional<WishList> findWishListByProductAndUser(Product product, User user){
        return this.wishlistRepository.findByProductAndUser(product,user);
    }
}
