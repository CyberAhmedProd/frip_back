package com.teamyostrik.efrip.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamyostrik.efrip.models.Order;
import com.teamyostrik.efrip.services.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping(path = "{orderid}")
    public Optional<Order> getOrder(@PathVariable("orderid") String id){
        return orderService.getOrder(id);
    }

    @PostMapping()
    public void addOrder (Order order) {
        orderService.addOrder(order);
    }
    
    @DeleteMapping(path ="{orderid}")
    public void deleteOrder(@PathVariable ("orderid") String id ) {
        orderService.deleteOrder(id);
    }
    
    @PutMapping (path = "{orderid}") 
    public void updateOrder(@PathVariable ("orderid") String id , Order order) {
        orderService.updateOrder(id,order);
    }
}
