package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Address;
import com.teamyostrik.efrip.models.LigneItem;
import com.teamyostrik.efrip.models.Order;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.AddressRepository;
import com.teamyostrik.efrip.repositories.LigneItemRepository;
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
	@Autowired
	private LigneItemRepository ligneItemRepository;
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(String id){
        return orderRepository.findById(id);
    }
    public void addOrder(Order order) {
    	
    	Address addressData = new Address();
    	addressData.setCity(order.getBillingAddress().getCity());
    	addressData.setCodePostal(order.getBillingAddress().getCodePostal());
    	addressData.setCountry(order.getBillingAddress().getCountry());
    	addressData.setStreet(order.getBillingAddress().getStreet());
    	order.setBillingAddress(addressRepository.save(addressData));
    	for (LigneItem li : order.getListLigneItem()) {
    		ligneItemRepository.save(li);
		}
        orderRepository.save(order);
    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public void updateOrder(String id,Order order) {
       
    }
}
