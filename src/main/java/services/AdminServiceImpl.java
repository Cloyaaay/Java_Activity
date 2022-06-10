/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Product;
import models.User;

/**
 *
 * @author suyao
 */
public class AdminServiceImpl implements AdminService{
    
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> productsAvailable = new ArrayList<>();
    private ArrayList<User> adminUsers = new ArrayList<>();
    
    public AdminServiceImpl(){
        adminUsers.add(new User("admin", "123"));
    }
    
    @Override
    public boolean isAnAdmin(User adminAcc) {
        boolean result = true;
        
        for(User adminUser: adminUsers){
            if(adminUser.getUserName().equals(adminAcc.getUserName()) && adminUser.getPassword().equals(adminAcc.getPassword())){
                result = true;
                break;
            }
            else {
                result = false;
            }
        }
        return result;
    }
    
    @Override
    public ArrayList<User> getAdminUsers() {
        return adminUsers;
    }

    @Override
    public void addProduct(Product product) {
        productsAvailable.add(product);
    }
    
    @Override
    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<Product> getProducts() {
        return productsAvailable;
    }

    @Override
    public void removeProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateProdStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showAdminScreen() {
        
        System.out.println("\n\n***********************");
        System.out.println("*    ADMINISTRATOR    *");
        System.out.println("***********************");
        System.out.println("1 - Manage Products");
        System.out.println("2 - Manage Orders");
        System.out.println("........................");
        System.out.println("0 - Logout\n");
        System.out.print("What do you want to do? : ");
    }
}
