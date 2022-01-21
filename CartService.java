package com.tjpeisde.onlineordersystem.service;
import com.tjpeisde.onlineordersystem.dao.CartDao;
import com.tjpeisde.onlineordersystem.entity.Cart;
import com.tjpeisde.onlineordersystem.entity.Customer;
import com.tjpeisde.onlineordersystem.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartDao cartDao;

    public Cart getCart() {
        Customer customer = customerService.getCustomer();

        if (customer != null) {
            Cart cart = customer.getCart();
            double totalPrice = 0;
            for (OrderItem item : cart.getOrderItemList()) {
                totalPrice += item.getPrice()* item.getQuantity();
            }
            cart.setTotalPrice(totalPrice);
            cartDao.updateCart(cart);
           return cart;
        }
        return new Cart();

    }
    public void cleanCart() {
        Customer customer = customerService.getCustomer();
        if (customer != null) cartDao.removeAllCartItems(customer.getCart());
    }


}