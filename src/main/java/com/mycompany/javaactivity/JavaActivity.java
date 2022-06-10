/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.javaactivity;

import java.util.ArrayList;
import java.util.Scanner;
import models.Product;
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
    static int mainChoice =2;
    static int roleChoice =2;
    static int adminChoice;
    
    public static void mainMenu (){
    
        System.out.println("\n\n***********************");
        System.out.println("* WELCOME TO MY SHOP! *");
        System.out.println("***********************");
        System.out.println("1 - Login");
        System.out.println("........................");
        System.out.println("0 - Exit\n");
        
        System.out.print("What do you want to do? : ");
    }
 
    public static void main(String[] args) {
        String userName;
        String password;
        
        String productName="";
        int productPrice=0;
        int productID = 0;
        int removeProduct;

        AdminService adminService = new AdminServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        
        ArrayList<User> adminUsers = adminService.getAdminUsers();
        ArrayList<User> customerUsers = customerService.getCustomerUsers();
        
        try{
            while(mainChoice!=0){
                
                if(mainChoice==2){
                    mainMenu();
                    mainChoice = console.nextInt();
                }
                if(mainChoice==1){
                    System.out.println("\n\n***********************");
                    System.out.println("*        LOGIN        *");
                    System.out.println("***********************");
                    System.out.print("Username: ");
                    userName = console.next();
                    System.out.print("Password: ");
                    password = console.next();
                    System.out.print("\n");

                    User logInUser = new User(userName, password);
                    
                    while (roleChoice!=0){
                        if (adminService.isAnAdmin(logInUser)){
                            adminService.showAdminScreen();
                            adminChoice = console.nextInt();
                            
                            if(adminChoice==1){
                                while(adminChoice!=0){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      PRODUCTS       *");
                                    System.out.println("***********************");

                                    System.out.println("ID \t Name \t Price");

                                    ArrayList<Product> productsAvailable = adminService.getProducts();

                                    if (productsAvailable.isEmpty()){
                                        System.out.println("  No Products Found.");
                                    }
                                    else{ 
                                        for(Product product: productsAvailable){
                                            System.out.println(product.getProductID() + "\t" + product.getProductName() + "\t" + product.getProductPrice());
                                        }
                                    }

                                    System.out.println("........................");
                                    System.out.println("1 - Add New Product");
                                    System.out.println("2 - Remove Product");
                                    System.out.println("0 - Back\n");
                                    System.out.print("What do you want to do? : ");

                                    adminChoice = console.nextInt();
                                    
                                    if (adminChoice==1){
                                        System.out.println("\n\n***********************");
                                        System.out.println("*     ADD PRODUCT     *");
                                        System.out.println("***********************");
                                        
                                        //TODO: VALIDATION
                                        
                                        System.out.print("Name: ");
                                        productName = console.next();
                                        
                                        System.out.print("Product Price: ");
                                        productPrice = console.nextInt();
                                        
                                        productID++;
                                        
                                        Product newProduct = new Product(productName, productID, productPrice);
                                        productsAvailable.add(newProduct);
                                    }
                                    
                                    else if(adminChoice==2){
                                        System.out.println("\n\n***********************");
                                        System.out.println("*    REMOVE PRODUCT    *");
                                        System.out.println("***********************");
                                        
                                        System.out.print("Product ID: ");
                                        removeProduct = console.nextInt();

                                        productsAvailable.remove(adminService.findProduct(removeProduct));
                                        
                                    }
                                }
                            }
                        else if (customerService.isACustomer(logInUser)){
                            customerService.showCustomerScreen();
                            roleChoice = console.nextInt();
                            mainChoice = 2;
                    }
                        else{
                            System.out.println("ERROR: Invalid Credentials");
                            System.out.println("Press 'ENTER' to Continue\n");
                            roleChoice=0;
                            mainChoice=2; 
                        }
                    }
                }
            }
            
            System.out.println("\nThank you for using our services!\n");
            
        }
    }
        
        catch (Exception e) {
            System.out.println();
            System.out.println("ERROR! Please Try Again." + e);
	} 	    
    }
}