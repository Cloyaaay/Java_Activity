/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import models.Product;
import models.User;

/**
 *
 * @author suyao
 */
public interface AdminService {
    
    public void showAdminScreen();
    
    public ArrayList<User> getAdminUsers();
    
    public ArrayList<Product> getProducts();
    
    public boolean isAnAdmin(User adminAcc);
    
    public void addProduct(Product product);
    
    public void removeProduct(Product product);
    
    public void removeProduct();
    
    public void updateProdStatus();
}