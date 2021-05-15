package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.Auction;
import com.teamyostrik.efrip.models.Bid;
import com.teamyostrik.efrip.services.AuctionService;
import com.teamyostrik.efrip.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/auction")
public class AuctionController {

    private final AuctionService auctionService;
    private final BidService bidService;
    @Autowired
    public AuctionController(AuctionService auctionService, BidService bidService) {
        this.auctionService = auctionService;
        this.bidService = bidService;
    }

    @GetMapping
    public List<Auction> getAllAuction(){
        return this.auctionService.getAllAuction();
    }

    @PostMapping(path="/add")

    public ResponseEntity<HashMap<Object, Object>> addAuction(@RequestBody Auction auction){
        HashMap<Object, Object> model=new HashMap<>();
        try{
            this.auctionService.addAuction(auction);
            model.put("success",1);
            model.put("message","auction added successfully");
        }catch(Exception e){
            model.put("success",0);
            model.put("message",e.getMessage());
        }
        return ok(model);
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<HashMap<Object, Object>> updateAuction(@PathVariable("id") String id,@RequestBody Auction auction){
        HashMap<Object, Object> model=new HashMap<>();
        try {
            this.auctionService.updateAuction(id,auction);
            model.put("success",1);
            model.put("message","auction updated successfully");
        } catch (Exception e) {
            model.put("success",0);
            model.put("message",e.getMessage());
        }

        return ok(model);

    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<HashMap<Object, Object>> deleteAuction(@PathVariable("id") String id){
        HashMap<Object, Object> model=new HashMap<>();
        try {
            this.auctionService.deleteAuction(id);
            model.put("success",1);
            model.put("message","auction deleted successfully");
        } catch (Exception e) {
            model.put("success",0);
            model.put("message",e.getMessage());
        }

        return ok(model);

    }

    @PostMapping(path="/bid/add/{id}")
    public ResponseEntity<HashMap<Object, Object>> addBid(@PathVariable("id")String id, @RequestBody Bid bid){
        HashMap<Object, Object> model=new HashMap<>();
        try {
            this.bidService.addBid(id,bid);
            model.put("success",1);
            model.put("message","bid added successfully");
        } catch (Exception e) {
            model.put("success",0);
            model.put("message",e.getMessage());
        }

        return ok(model);
    }

}
