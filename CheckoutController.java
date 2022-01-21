package com.tjpeisde.onlineordersystem.controller;

import com.tjpeisde.onlineordersystem.service.CartService;
import com.tjpeisde.onlineordersystem.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
public class CheckoutController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderHistoryService orderHistoryService;


    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void checkout() {
        orderHistoryService.checkOut();
    }

    @RequestMapping(value = "/cleanCart", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void cleanCart() {
        cartService.cleanCart();
    }
}