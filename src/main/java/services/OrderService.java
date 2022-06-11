/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import models.Order;
import models.Product;

/**
 *
 * @author suyao
 */
public interface OrderService {
    
    public int computeTotalPrice(Product order, int quantity);
    
    public String generateReferenceCode();
    
    public Date generateOrderDate();
    
    public void placeOrder(Order product);
    
    public ArrayList<Order> getOrders();
    
    public Order findOrder(String reference);
    
}
