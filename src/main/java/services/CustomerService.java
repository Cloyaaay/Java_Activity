/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import models.User;

/**
 *
 * @author suyao
 */
public interface CustomerService {
    
    public void showCustomerScreen();
    
    public boolean isACustomer(User customerAcc);
    
    public ArrayList<User> getCustomerUsers();
    
    public void placeOrder();
}
