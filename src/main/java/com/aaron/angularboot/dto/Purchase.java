package com.aaron.angularboot.dto;

import com.aaron.angularboot.entity.Address;
import com.aaron.angularboot.entity.Customer;
import com.aaron.angularboot.entity.Order;
import com.aaron.angularboot.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
