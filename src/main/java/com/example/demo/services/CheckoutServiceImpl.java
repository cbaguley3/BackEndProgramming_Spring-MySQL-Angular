package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        // Check if cart or cartItems are null or empty
        if (cart == null || cartItems == null || cartItems.isEmpty()) {
            return new PurchaseResponse("Cannot place order: Cart or CartItems are null or empty");
        }

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populate cart with cartItems
        cartItems.forEach(cartItem -> cartItem.setCart(cart));

        // Populate cart with customer
        Customer customer = purchase.getCustomer();
        cart.setCustomer(customer);

        // Set status type to "ordered"
        cart.setStatus(ordered);

        // Save to database
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}



