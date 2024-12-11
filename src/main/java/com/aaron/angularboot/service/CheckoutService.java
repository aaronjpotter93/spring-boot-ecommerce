package com.aaron.angularboot.service;

import com.aaron.angularboot.dto.Purchase;
import com.aaron.angularboot.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
