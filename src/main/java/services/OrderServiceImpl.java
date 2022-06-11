/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.util.Random;
import models.Order;
import models.Product;

/**
 *
 * @author suyao
 */
public class OrderServiceImpl implements OrderService{
    
    private ArrayList<Order> customerOrders = new ArrayList<>();

    public OrderServiceImpl() {
    }

    @Override
    public int computeTotalPrice(Product order, int quantity) {
        int totalPrice=0;
        totalPrice = order.getProductPrice()*quantity;
        return totalPrice;
    }

    @Override
    public String generateReferenceCode() {
        String referenceCode="";
        Random random = new Random();
        
        for(int i=0; i<5; i++){
            char randomChar = (char) (random.nextInt(26) + 'a');
            referenceCode = referenceCode + randomChar;
        }
        return referenceCode.toUpperCase();
    }

    @Override
    public Date generateOrderDate() {
         Date date = new java.util.Date();
         return date;
    }

    @Override
    public void placeOrder(Order product) {
        customerOrders.add(product);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return customerOrders;
    }
    
}
