package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Auction;
import com.teamyostrik.efrip.models.Bid;
import com.teamyostrik.efrip.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    private final AuctionService auctionService;

    private final BidRepository bidRepository;

    @Autowired
    public BidService(AuctionService auctionService, BidRepository bidRepository) {
        this.auctionService = auctionService;
        this.bidRepository = bidRepository;

    }

    public void addBid(String id , Bid bid) throws Exception{
        Optional<Auction> auctionToUpdate=this.auctionService.getAuctionById(id);

        auctionToUpdate.ifPresent(auction -> {
            if(bid.getBidAmount() > getMaxBid(auction.getBids())){
                Bid newBid=bidRepository.save(bid);
                auction.getBids().add(newBid);
                try {
                    auctionService.updateAuction(id,auction);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }else{
                throw new RuntimeException("bid must be higher than " + getMaxBid(auction.getBids()));
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
