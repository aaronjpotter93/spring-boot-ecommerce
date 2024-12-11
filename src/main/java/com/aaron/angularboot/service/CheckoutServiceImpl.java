package com.aaron.angularboot.service;

import com.aaron.angularboot.dao.CustomerRepository;
import com.aaron.angularboot.dto.Purchase;
import com.aaron.angularboot.dto.PurchaseResponse;
import com.aaron.angularboot.entity.Customer;
import com.aaron.angularboot.entity.Order;
import com.aaron.angularboot.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //get order
        Order order = purchase.getOrder();

        //generate uuid for tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();

        //set tracking number for order
        order.setOrderTrackingNumber(orderTrackingNumber);

        //create collection of all order items
        Set<OrderItem> orderItems = purchase.getOrderItems();

        //add each order item to order
        orderItems.forEach(order::add);

        //set billing and shipping addresses for the order
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //add order to customer
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save customer and their order to database
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
