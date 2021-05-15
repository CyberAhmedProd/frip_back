package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Auction;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.repositories.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;
    @Autowired
    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> getAllAuction(){
        return this.auctionRepository.findAll();
    }
    public Optional<Auction> getAuctionById(String id){
        return this.auctionRepository.findById(id);
    }
    public Optional<Auction> getAuctionByProduct(Product product){
        return this.auctionRepository.findByProduct(product);
    }

    public void addAuction(Auction auction){
        this.auctionRepository.save(auction);
    }

    public void updateAuction(String id , Auction auction) throws Exception{
        if(this.auctionRepository.existsById(id)){
            this.auctionRepository.save(auction);
        }
        throw  new RuntimeException("No Auction with this id");
    }
    public void deleteAuction(String id) throws Exception{
        if (this.auctionRepository.existsById(id)){
            this.auctionRepository.deleteById(id);
        }
        throw  new RuntimeException("No Auction with this id");
    }
}
