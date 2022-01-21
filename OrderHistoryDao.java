package com.tjpeisde.onlineordersystem.dao;

import com.tjpeisde.onlineordersystem.entity.OrderHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderHistoryDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(OrderHistory orderHistory) {
        System.out.println("OH DAO start");
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(orderHistory);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
