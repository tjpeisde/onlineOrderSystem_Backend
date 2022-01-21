package com.tjpeisde.onlineordersystem.dao;

import com.tjpeisde.onlineordersystem.entity.Authorities;
import com.tjpeisde.onlineordersystem.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;
    //整个文档只有一个sessionFactory；
    //共享

    public void signUp(Customer customer) {
        Session session = null; //开一个session （一个线程）
        Authorities authorities = new Authorities();
        authorities.setEmail(customer.getEmail());
        authorities.setAuthorities("ROLE_USER");

        try{
            session = sessionFactory.openSession(); //获得session 对象
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
            // 回到写事物(transaction)之前的状态

        } finally {
            if (session != null) session.close();
        }
    }

    public Customer getCustomer(String email) {
        Customer customer = null;
        /*
        Session session = null;
        try{
            session = sessionFactory.openSession();
            customer = session.get(Customer.class,email); // 不存在返回null
            // 暂时未考虑要多线程
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session != null) session.close();
        }
        */
        try (Session session = sessionFactory.openSession()) {
            // try with resource 写法 try 里一定要写new instance， try 完就清空
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public void updatePassword(String email, String password) {

        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, email);
            customer.setPassword(password);
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
