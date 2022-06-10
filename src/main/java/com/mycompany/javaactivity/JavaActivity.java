/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.javaactivity;

import java.util.ArrayList;
import java.util.Scanner;
import models.User;
import services.AdminService;
import services.AdminServiceImpl;
import services.CustomerService;
import services.CustomerServiceImpl;

/**
 *
 * @author suyao
 */
public class JavaActivity {
    static Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int choice;
        String userName;
        String password;
        
        System.out.println("***********************");
        System.out.println("* WELCOME TO MY SHOP! *");
        System.out.println("***********************");
        System.out.println("1 - Login");
        System.out.println("........................");
        System.out.println("0 - Exit");
        
        System.out.print("What do you want to do? : ");
        choice = console.nextInt();

        AdminService adminService = new AdminServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        
        ArrayList<User> adminUsers = adminService.getAdminUsers();
        ArrayList<User> customerUsers = customerService.getCustomerUsers();
        
//        for(User adminUser: adminUsers){
//            System.out.println("Username: " + adminUser.getUserName());
//            System.out.println("Username: " + adminUser.getPassword());
//            System.out.println("***********************");
//        }
        try{
            if(choice==1){
                System.out.println("***********************");
                System.out.println("*        LOGIN        *");
                System.out.println("***********************\n");
                System.out.print("Username: ");
                userName = console.next();
                System.out.print("Password: ");
                password = console.next();
                System.out.print("\n");
                
                User logInUser = new User(userName, password);
                
                if (adminService.isAnAdmin(logInUser)){
                    adminService.showAdminScreen();
                }
                else if (customerService.isACustomer(logInUser)){
                    customerService.showCustomerScreen();
                }
                else{
                    System.out.println("ERROR: Invalid Credentials");
                    System.out.println("Press 'ENTER' to Continue");
                }
            }
        }
        
        catch (Exception e) {
            System.out.println();
            System.out.println("ERROR! Please Try Again." + e);
	} 	    
    }
}