/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Khalid
 */
public class Order {
    
    private User user;
    private int user_id;
    private int itemid;
    private Item item;
    private int quantity, order_id;
    private String status;
    private float total_cost;
    private Date date;
private int id;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Order() {
    }    
    

    public Order(User user, Item item, int quantity, int order_id, String status, float total_cost) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.order_id = order_id;
        this.status = status;
        this.total_cost = total_cost;
    }
    
    public Order(User user, Item item, int quantity, float total_cost) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.total_cost = total_cost;
    }

    public Order(int userid, int itemid, int quantity, String status, float total_cost, Date date, int id) {
        this.user_id = userid;
        this.itemid = itemid;
        this.quantity = quantity;
        this.status = status;
        this.total_cost = total_cost;
        this.date = date;
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public User getUser() {
        return user;
    }

    public int getUserid() {
        return user_id;
    }

    public void setUserid(int userid) {
        this.user_id = userid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    
    
}
