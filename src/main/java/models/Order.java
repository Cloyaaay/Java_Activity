/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author suyao
 */
public class Order extends Product{
    
    private Date orderDate;
    private int productQuatity;
    private int totalPrice;
    private String orderStatus;
    
    public Order(String productName, int productID, int productPrice, int productQuantity){
        super(productName, productID, productPrice);
        this.productQuatity = productQuantity;
    }
    
    public Order(String productName, int productID, int productPrice, Date orderDate, int productQuantity, int totalPrice, String orderStatus){
        super(productName, productID, productPrice);
        this.orderDate = orderDate;
        this.productQuatity = productQuantity;
        this.totalPrice = totalPrice;
        this.orderStatus = "FOR_DELIVERY";
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductQuatity() {
        return productQuatity;
    }

    public void setProductQuatity(int productQuatity) {
        this.productQuatity = productQuatity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
}
