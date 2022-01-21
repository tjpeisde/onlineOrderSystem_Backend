package com.tjpeisde.onlineordersystem.service;

import com.tjpeisde.onlineordersystem.dao.MenuInfoDao;
import com.tjpeisde.onlineordersystem.entity.Catalog;
import com.tjpeisde.onlineordersystem.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MenuInfoService {
    @Autowired
    private MenuInfoDao menuInfoDao;


    public List<Catalog> getCatalogs() {
        return menuInfoDao.getCatalogs();
    }
    public List<MenuItem> getMenusByCatalog(int catalogId) {
        return menuInfoDao.getMenusByCatalog(catalogId);
    }

    public MenuItem getMenuItem(int menuItemId) {
        return menuInfoDao.getMenuItem(menuItemId);
    }
    public List<MenuItem> getAllMenuItems(){
        System.out.println("get all menu items");
        return menuInfoDao.getMenuItems();}
}