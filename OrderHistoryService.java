package com.tjpeisde.onlineordersystem.service;

import com.tjpeisde.onlineordersystem.dao.CartDao;
import com.tjpeisde.onlineordersystem.dao.OrderHistoryDao;
import com.tjpeisde.onlineordersystem.entity.Cart;
import com.tjpeisde.onlineordersystem.entity.Customer;
import com.tjpeisde.onlineordersystem.entity.OrderHistory;
import com.tjpeisde.onlineordersystem.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderHistoryService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private HistoryItemService historyItemService;
    @Autowired
    private OrderHistoryDao orderHistoryDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private CartService cartService;

    public void checkOut() {
        Customer customer = customerService.getCustomer();
        Cart cart = cartService.getCart();
        final OrderHistory orderHistory = new OrderHistory();
        orderHistory.setCustomer(customer);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        orderHistory.setDate(dtf.format(now));
        orderHistory.setTotalPrice(cart.getTotalPrice());
        orderHistoryDao.save(orderHistory);

        for (OrderItem item : cart.getOrderItemList()) {
            historyItemService.create(item,orderHistory);
        }
        cartDao.removeAllCartItems(customer.getCart());
    }
}
