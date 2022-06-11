/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.javaactivity;

import java.util.ArrayList;
import java.util.Scanner;
import models.Order;
import models.Product;
import models.User;
import services.AdminService;
import services.AdminServiceImpl;
import services.CustomerService;
import services.CustomerServiceImpl;
import services.OrderService;
import services.OrderServiceImpl;

/**
 *
 * @author suyao
 */
public class JavaActivity {
    static Scanner console = new Scanner(System.in);
    static int mainChoice =2;
    static int roleChoice =2;
    static int adminChoice;
    static int manageProductChoice;
    static int customerChoice;
    
    
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
        String answer;
        boolean isValid=true;
        
        
        int orderProduct;
        int orderQuantity = 0;
        int totalPrice=0;
        boolean isValid2=true;
        boolean isValid3=true;

        AdminService adminService = new AdminServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        
        ArrayList<User> adminUsers = adminService.getAdminUsers();
        ArrayList<User> customerUsers = customerService.getCustomerUsers();
        ArrayList<Product> productsAvailable = adminService.getProducts();
        ArrayList<Order> customerOrders = orderService.getOrders();
        
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
                    roleChoice=1;
                    
                    while (roleChoice!=0){
                        if (adminService.isAnAdmin(logInUser)){
                            adminService.showAdminScreen();
                            adminChoice = console.nextInt();
                            roleChoice=adminChoice;

                            while(adminChoice!=0){
                                if(adminChoice==1){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      PRODUCTS       *");
                                    System.out.println("***********************");

                                    System.out.println("ID \t Name \t Price");

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

                                    manageProductChoice = console.nextInt();

                                    if (manageProductChoice==1){
                                        System.out.println("\n\n***********************");
                                        System.out.println("*     ADD PRODUCT     *");
                                        System.out.println("***********************");

                                        //TODO: VALIDATION

                                        System.out.print("Name: ");
                                        productName = console.next();

                                        do{
                                            try{
                                                System.out.print("Product Price: ");
                                                productPrice = console.nextInt();
                                                isValid=true;

                                            }
                                            catch (Exception e){
                                                System.out.println("Invalid number. Please try again.");
                                                console.next();
                                                isValid=false;
                                            }
                                        }
                                        while(!isValid);

                                        productID++;

                                        Product newProduct = new Product(productName, productID, productPrice);
                                        productsAvailable.add(newProduct);
                                    }

                                    else if(manageProductChoice==2){
                                        System.out.println("\n\n***********************");
                                        System.out.println("*    REMOVE PRODUCT    *");
                                        System.out.println("***********************");
                                        do{
                                            try{
                                                System.out.print("Product ID: ");
                                                removeProduct = console.nextInt();
                                                isValid=true;
                                                
                                                if(productsAvailable.isEmpty()){
                                                    System.out.print("No products found. Nothing to delete here.");
                                                    isValid=false;
                                                    break;
                                                }
                                                else if((adminService.findProduct(removeProduct))== null){
                                                    System.out.print("Product not found. Please try again.");
                                                    isValid=false;
                                                    break;
                                                }
                                                System.out.print("Are you sure you want to remove this product? (Y/N): ");
                                                answer = console.next();

                                                if (answer.equals("Y") || answer.equals("y")){
                                                    productsAvailable.remove(adminService.findProduct(removeProduct));
                                                    System.out.print("Product removed successfully!");
                                                }
                                                else{
                                                    System.out.print("Action Canceled");
                                                }
                                            }
                                            catch (Exception e){
                                                System.out.println("Invalid Input. Please try again");
                                                console.next();
                                                isValid=false;
                                            }
                                        }
                                        while(!isValid);
                                    }
                                    else{
                                        break;
                                    }
                                }
                            }
                        }
                        else if (customerService.isACustomer(logInUser)){
                            customerService.showCustomerScreen();
                            customerChoice = console.nextInt();
                            roleChoice=customerChoice;
                            
                            while(customerChoice!=0){
                                if (customerChoice==1){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      PRODUCTS       *");
                                    System.out.println("***********************");

                                    System.out.println("ID \t Name \t Price");
                                    
                                    if (productsAvailable.isEmpty()){
                                        System.out.println("  No Products Found.");
                                    }
                                    else{ 
                                        for(Product product: productsAvailable){
                                            System.out.println(product.getProductID() + "\t" + product.getProductName() + "\t" + product.getProductPrice());
                                        }
                                    }
                                    System.out.println("........................");
                                    System.out.println("0 - Back\n");
                                    do{
                                        try{
                                            System.out.print("What do you want to order? : ");
                                            orderProduct = console.nextInt();
                                            customerChoice=orderProduct;
                                            isValid=true;
                                            
                                            if(customerChoice==0){
                                                
                                                break;
                                            }

                                            if(productsAvailable.isEmpty()){
                                                System.out.print("No products found. Nothing to delete here.");
                                                isValid=false;
                                                break;
                                            }
                                            else if((adminService.findProduct(orderProduct))== null){
                                                System.out.print("Product not found. Please try again.");
                                                isValid=false;
                                                break;
                                            }
                                            Product product = adminService.findProduct(orderProduct);
                                            
                                            System.out.println("\n\n***********************");
                                            System.out.println("*     PLACE ORDER     *");
                                            System.out.println("***********************");

                                            System.out.println("ID \t Name \t Price");
                                            System.out.println(product.getProductID() + "\t" + product.getProductName() + "\t" + product.getProductPrice());
                                            
                                            System.out.println("........................");
                                            
                                            do{
                                                try{
                                                    System.out.print("How many do you want? : ");
                                                    orderQuantity = console.nextInt();
                                                    isValid2=true;
                                                }
                                                catch(Exception e){
                                                    System.out.println("Invalid Input. Please try again");
                                                    console.next();
                                                    isValid2=false;
                                                }
                                            }
                                            while(!isValid2);
                                            
                                            totalPrice = orderService.computeTotalPrice(product, orderQuantity);
                                            
                                            System.out.println("That would be Php " + totalPrice);

                                            do{
                                                try{
                                                    System.out.print("Proceed with your order (Y/N): ");
                                                    answer = console.next();

                                                    if (answer.equals("Y") || answer.equals("y")){
                                                        Order order = new Order(product.getProductName(), product.getProductID(), product.getProductPrice());
                                                        order.setOrderDate(orderService.generateOrderDate());
                                                        order.setReference(orderService.generateReferenceCode());
                                                        order.setOrderStatus("FOR_DELIVERY");
                                                        order.setProductQuatity(orderQuantity);
                                                        order.setTotalPrice(totalPrice);
                                                        customerOrders.add(order);
                                                        System.out.print("Order placed successfully!");
                                                        isValid3=true;
                                                    }
                                                    else{
                                                        System.out.print("Action Canceled");
                                                        isValid3=true;
                                                    }
                                                }
                                                catch(Exception e){
                                                    System.out.println("Invalid Character. Please try again");
                                                    console.next();
                                                    isValid3=false;
                                                }
                                            }
                                            while(!isValid3);
                                        }
                                        catch (Exception e){
                                            System.out.println("Invalid Input. Please try again");
                                            console.next();
                                            isValid=false;
                                        }    
                                    }
                                    while(!isValid);  
                                }
                                else if(customerChoice==2){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      MY ORDERS      *");
                                    System.out.println("***********************");

                                    System.out.println("Date \t\t\t\t Reference \t Name \t Price \t Quantity \t Total \t Status");
                                    
                                    if (customerOrders.isEmpty()){
                                        System.out.println("  No Orders Found.");
                                    }
                                    else{ 
                                        for(Order order: customerOrders){
                                            System.out.println(order.getOrderDate() + "\t " + order.getReference() +"\t\t" + order.getProductName() + "\t\t" 
                                            + order.getProductPrice() + "\t\t" + order.getProductQuatity() + "\t" + order.getTotalPrice() + "\t\t" + order.getOrderStatus());
                                        }
                                    }
                                }
                                customerChoice=0;
                            }
                        }
                        else{
                            System.out.println("ERROR: Invalid Credentials");
                            System.out.println("Press 'ENTER' to Continue\n");
                            roleChoice=0;
                            mainChoice=2; 
                        }
                    }
                }
                if(mainChoice==0){
                    System.out.println("\nThank you for using our services!\n");
                }
//                roleChoice=0;
                else{
                    mainChoice=2;
                }
            }
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("ERROR! Please Try Again." + e);
	} 	    
    }
}