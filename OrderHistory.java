package com.tjpeisde.onlineordersystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orderhistory")
public class OrderHistory implements Serializable {

    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double totalPrice;

    private String date;

    @OneToMany(mappedBy = "orderHistory", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<HistoryItem> historyItemList;

    @ManyToOne
    @JsonIgnore
    private Customer customer;



    public List<HistoryItem> getHistoryItemList() {
        return historyItemList;
    }

    public void setHistoryItemList(List<HistoryItem> historyItemList) {
        this.historyItemList = historyItemList;
    }


     public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
