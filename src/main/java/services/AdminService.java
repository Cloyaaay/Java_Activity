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
public interface AdminService {
    
    public void showAdminScreen();
    
    public void addAdmin(User adminUser);
    
    public ArrayList<User> getAdminUsers();
    
    public boolean isAnAdmin(User adminAcc);
    
    public void addProduct();
    
    public void removeProduct();
    
    public void updateProdStatus();
}