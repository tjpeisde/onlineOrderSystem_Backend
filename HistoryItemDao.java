package com.tjpeisde.onlineordersystem.dao;

import com.tjpeisde.onlineordersystem.entity.HistoryItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryItemDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(HistoryItem historyItem) {
        System.out.println("HI.dao start");
        Session session = null;
        try {
            System.out.println("HI.dao inner");
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(historyItem);
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
