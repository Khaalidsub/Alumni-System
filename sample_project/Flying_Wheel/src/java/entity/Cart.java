/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Bellarina C
 */
public class Cart {
    private User user;
    private Item item;
    private int quantity, cartID, total_quantity;
    private float total, grandtotal;
    

    public Cart() {
    }
    
    public Cart(int cartID, User user, Item item, int quantity) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.cartID = cartID;
    }

    public Cart(User user, Item item, int quantity, int cartID, int total_quantity, float total, float grandtotal) {
        this.user = user;
        this.item = item;
        this.quantity = quantity;
        this.cartID = cartID;
        this.total_quantity = total_quantity;
        this.total = total;
        this.grandtotal = grandtotal;
    }

    public void setGrandtotal(float grandtotal) {
        this.grandtotal = grandtotal;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public float getGrandtotal() {
        return grandtotal;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }
    

    public int getCartID() {
        return cartID;
    }
    
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotal() {
        return total;
    }

    public User getUser() {
        return user;
    }
    
}
