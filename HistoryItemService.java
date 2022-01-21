package com.tjpeisde.onlineordersystem.service;

import com.tjpeisde.onlineordersystem.dao.HistoryItemDao;
import com.tjpeisde.onlineordersystem.entity.HistoryItem;
import com.tjpeisde.onlineordersystem.entity.MenuItem;
import com.tjpeisde.onlineordersystem.entity.OrderHistory;
import com.tjpeisde.onlineordersystem.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HistoryItemService {
    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private HistoryItemDao historyItemDao;
    public void create(OrderItem orderItem, OrderHistory orderHistory) {
        final HistoryItem historyItem = new HistoryItem();
        final MenuItem menuItem = orderItem.getMenuItem();
        historyItem.setOrderHistory(orderHistory);
        historyItem.setMenuItem(menuItem);
        historyItem.setPrice(orderItem.getPrice());
        historyItem.setQuantity(orderItem.getQuantity());
        historyItemDao.save(historyItem);
    }
}