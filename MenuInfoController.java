package com.tjpeisde.onlineordersystem.controller;
import com.tjpeisde.onlineordersystem.entity.Catalog;
import com.tjpeisde.onlineordersystem.entity.MenuItem;
import com.tjpeisde.onlineordersystem.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;



    @RequestMapping(value = "/catalogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Catalog> getCatalogs() {
        return menuInfoService.getCatalogs();
    }
    @RequestMapping(value ="/catalog/{catalogId}/menu",method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenusByCatalog(@PathVariable("catalogId") int catalogId) {
        return menuInfoService.getMenusByCatalog(catalogId);
    }
    @RequestMapping(value = "/allMenuItems", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getAllMenuItems() {
        return menuInfoService.getAllMenuItems();
    }
    }

