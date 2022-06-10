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
public class CustomerServiceImpl implements CustomerService{

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> customerOrders = new ArrayList<>();
    private ArrayList<User> customerUsers = new ArrayList<>();
    
    public CustomerServiceImpl(){
        customerUsers.add(new User("customer1", "helloWorld2*"));
    }
    
    @Override
    public boolean isACustomer(User customerAcc) {
        boolean result = true;
        
        for(User customerUser: customerUsers){
            if(customerUser.getUserName().equals(customerAcc.getUserName()) && customerUser.getPassword().equals(customerAcc.getPassword())){
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
    public void addCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public ArrayList<User> getCustomerUsers() {
        return customerUsers;
    }

    @Override
    public void placeOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showCustomerScreen() {
        int choice;
        
        System.out.println("\n\n***********************");
        System.out.println("*      CUSTOMER      *");
        System.out.println("***********************");
        System.out.println("1 - Shop");
        System.out.println("2 - My Orders");
        System.out.println("........................");
        System.out.println("0 - Logout\n");
        
        System.out.print("What do you want to do? : ");
    }
    
}
