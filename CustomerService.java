package com.tjpeisde.onlineordersystem.service;


import com.tjpeisde.onlineordersystem.dao.CustomerDao;
import com.tjpeisde.onlineordersystem.entity.Cart;
import com.tjpeisde.onlineordersystem.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
/* 不推荐 因为如果加了final 就出错
    @Autowired
    private CustomerDao customerDao;

 */
    //推荐
    private CustomerDao customerDao;
    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;

    }
    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        return customerDao.getCustomer(email);
    }

    public void updatePassword(String password) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        customerDao.updatePassword(email, password);
    }
}
