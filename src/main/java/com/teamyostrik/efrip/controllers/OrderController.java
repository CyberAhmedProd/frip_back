package com.teamyostrik.efrip.controllers;


import com.teamyostrik.efrip.models.Order;
import com.teamyostrik.efrip.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/order")
public class OrderController {
	@Autowired
    private OrderService orderService;
   
    @GetMapping(path = "/getting")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(path = "/{id}")
    public Optional<Order> getOrder(@PathVariable("id") String id) {
        return orderService.getOrder(id);
    }

    @PostMapping()
    public ResponseEntity<HashMap<Object, Object>> addOrder(@RequestBody Order order) {
        Order orderData = orderService.addOrder(order);
        HashMap<Object, Object> model = new HashMap<>();
        if (orderData == null) {
            model.put("success", 1);
            model.put("message", "order " + order.getId() + " added successfully");
        } else {
            model.put("success", 0);
            model.put("message", "no more stock!");
        }
        return ok(model);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrder(@PathVariable("id") String id) {
        orderService.deleteOrder(id);
    }

    @PutMapping(path = "/shipping/{id}")
    public void shippingOrder(@PathVariable("id") String id, Order order) {
        orderService.sippedOrder(id, order);
    }
    @PutMapping(path = "/hold/{id}")
    public void holdOrder(@PathVariable("id") String id, Order order) {
        orderService.holdOrder(id, order);
    }
    @PutMapping(path = "/delivered/{id}")
    public void deliveredOrder(@PathVariable("id") String id, Order order) {
        orderService.deliveredOrder(id, order);
    }
}
