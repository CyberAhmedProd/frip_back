package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Auction;
import com.teamyostrik.efrip.models.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    private final AuctionService auctionService;

    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public BidService(AuctionService auctionService, ProductService productService, UserService userService) {
        this.auctionService = auctionService;
        this.productService = productService;
        this.userService = userService;
    }

    public void addBid(String id , Bid bid) throws Exception{
        Optional<Auction> auctionToUpdate=this.auctionService.getAuctionById(id);

        auctionToUpdate.ifPresent(auction -> {
            if(bid.getBidAmount() > getMaxBid(auction.getBids())){
                auction.getBids().add(bid);
                try {
                    auctionService.updateAuction(id,auction);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

//            this.auctionService.addAuction(auction);
        });
    }

    public Double getMaxBid(List<Bid> bids){
        Double max= Double.MIN_VALUE;
        for(Bid bid: bids){
            if(bid.getBidAmount() > max){
                max=bid.getBidAmount();
            }
        }
        return max;
    }
}
