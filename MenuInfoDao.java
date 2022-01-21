package com.tjpeisde.onlineordersystem.dao;

import com.tjpeisde.onlineordersystem.entity.Catalog;
import com.tjpeisde.onlineordersystem.entity.MenuItem;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MenuInfoDao {
    @Autowired
    private SessionFactory sessionFactory;


    public List<Catalog> getCatalogs() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Catalog.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
    public List<MenuItem> getMenuItems() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(MenuItem.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }


    public List<MenuItem> getMenusByCatalog(int catalogId) {
        try (Session session = sessionFactory.openSession()) {
            Catalog catalog = session.get(Catalog.class, catalogId);
            // get 不能返回list 只能返回一个东西
            if (catalog != null) {
                return catalog.getMenuItemList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
