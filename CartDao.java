package com.tjpeisde.onlineordersystem.dao;

import com.tjpeisde.onlineordersystem.entity.Cart;
import com.tjpeisde.onlineordersystem.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void removeCartItem(int cartItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderItem cartItem = session.get(OrderItem.class, cartItemId);
            Cart cart = cartItem.getCart();
            cart.getOrderItemList().remove(cartItem);
            cart.setTotalPrice(cart.getTotalPrice() - cartItem.getPrice()*cartItem.getQuantity());
            session.beginTransaction();
            session.delete(cartItem);
            session.update(cart);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void removeAllCartItems(Cart cart) {
        for (OrderItem item : cart.getOrderItemList()) {
            removeCartItem(item.getId());
        }
    }

    public void updateCart(Cart cart){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(cart);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
