package com.tjpeisde.onlineordersystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "catalog")
public class Catalog implements Serializable {

    private static final long serialVersionUID = 2455760938054036111L;

    @Id
    private int id;

    private String name;


    private String imageUrl;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<MenuItem> menuItemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
}
