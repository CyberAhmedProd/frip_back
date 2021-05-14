package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Address;
import com.teamyostrik.efrip.models.Order;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.AddressRepository;
import com.teamyostrik.efrip.repositories.OrderRepository;
import com.teamyostrik.efrip.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService  {
	@Autowired
    private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
  
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(String id){
        return orderRepository.findById(id);
    }
    public void addOrder(Order order) {
    	
    	Optional<User> userData = userRepository.findById(order.getUser().getId());
    	if(userData.isPresent()){
    		order.setUser(userData.get());
    	}
    	Address addressData = new Address();
    	addressData.setCity(order.getBillingAddress().getCity());
    	addressData.setCodePostal(order.getBillingAddress().getCodePostal());
    	addressData.setCountry(order.getBillingAddress().getCountry());
    	addressData.setStreet(order.getBillingAddress().getStreet());
    	order.setBillingAddress(addressRepository.save(addressData));
        orderRepository.save(order);
    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public void updateOrder(String id,Order order) {
       
    }
}
