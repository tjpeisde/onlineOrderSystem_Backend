package com.tjpeisde.onlineordersystem.service;

import com.tjpeisde.onlineordersystem.dao.OrderItemDao;
import com.tjpeisde.onlineordersystem.entity.Cart;
import com.tjpeisde.onlineordersystem.entity.Customer;
import com.tjpeisde.onlineordersystem.entity.MenuItem;
import com.tjpeisde.onlineordersystem.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderItemDao orderItemDao;
    public void saveItem(int menuId) {
        Customer customer = customerService.getCustomer();
        Cart cart = customer.getCart();
        List<OrderItem> orderItemList = cart.getOrderItemList();
        for (OrderItem item: orderItemList ) {
            if (item.getMenuItem().getId() == menuId){
                System.out.println("find same menuid");
                orderItemDao.updateAdd(item);
                return;
            }
        }

        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);
        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        orderItemDao.save(orderItem);


    }
}