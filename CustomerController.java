package com.tjpeisde.onlineordersystem.controller;

import com.tjpeisde.onlineordersystem.entity.Customer;
import com.tjpeisde.onlineordersystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/updatePassword/{password}" , method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePassword(@PathVariable("password") String password){
        customerService.updatePassword(password);
    }

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerInfo(){

        return customerService.getCustomer();
    }
}
