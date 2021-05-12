package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Order;
import com.teamyostrik.efrip.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService  {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(String id){
        return orderRepository.findById(id);
    }
    public void addOrder(Order order) {
        orderRepository.save(order);
    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public void updateOrder(String id,Order order) {
        Optional<Order> orderdata = orderRepository.findById(id);

        orderdata.ifPresent(order1 -> {
           order1.setUser(order.getUser());
           order1.setProducts(order.getProducts());

        });
    }
}
