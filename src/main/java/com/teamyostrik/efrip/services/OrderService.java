package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Address;
import com.teamyostrik.efrip.models.LigneItem;
import com.teamyostrik.efrip.models.Order;
import com.teamyostrik.efrip.models.OrderStatus;
import com.teamyostrik.efrip.models.Payment;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.AddressRepository;
import com.teamyostrik.efrip.repositories.CartRepository;
import com.teamyostrik.efrip.repositories.LigneItemRepository;
import com.teamyostrik.efrip.repositories.OrderRepository;
import com.teamyostrik.efrip.repositories.PaymentRepository;
import com.teamyostrik.efrip.repositories.ProductRepository;
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
	private CartRepository cartRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private LigneItemRepository ligneItemRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ProductRepository productRepository;
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(String id){
        return orderRepository.findById(id);
    }
    public Order addOrder(Order order) {
    	
    	Address addressData = new Address();
    	addressData.setCity(order.getBillingAddress().getCity());
    	addressData.setCodePostal(order.getBillingAddress().getCodePostal());
    	addressData.setCountry(order.getBillingAddress().getCountry());
    	addressData.setStreet(order.getBillingAddress().getStreet());
    	order.setBillingAddress(addressRepository.save(addressData));
    	for (LigneItem li : order.getListLigneItem()) {
    		
    			Optional<Product> productData = productRepository.findById(li.getProduct().getId());
    			if(productData.isPresent()) {
    				Product productUpdate = productData.get();
    				productUpdate.setQuantity(li.getQuantity());
    				ligneItemRepository.save(li);
    			}
    		
		}
    	cartRepository.deleteByUser(order.getUser());
    	Payment paymentData = new Payment();
    	paymentData.setPaidDate(order.getPayment().getPaidDate());
    	paymentData.setDetails(order.getPayment().getDetails());
    	paymentData.setTotalPaid(order.getPayment().getTotalPaid());
    	order.setPayment(paymentRepository.save(paymentData));
        orderRepository.save(order);
        return order;
    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public void sippedOrder(String id,Order order) {
    	Optional<Order> orderData = orderRepository.findById(id);
    	if(orderData.isPresent()) {
    		Order orderUpdate = orderData.get();
    		orderUpdate.setStatus(OrderStatus.Shipped);
    		orderRepository.save(orderUpdate);
    	}
    }
    public void holdOrder(String id,Order order) {
    	Optional<Order> orderData = orderRepository.findById(id);
    	if(orderData.isPresent()) {
    		Order orderUpdate = orderData.get();
    		orderUpdate.setStatus(OrderStatus.Hold);
    		orderRepository.save(orderUpdate);
    	}
    }
    public void deliveredOrder(String id,Order order) {
    	Optional<Order> orderData = orderRepository.findById(id);
    	if(orderData.isPresent()) {
    		Order orderUpdate = orderData.get();
    		orderUpdate.setStatus(OrderStatus.Delivered);
    		orderRepository.save(orderUpdate);
    	}
    }
}
