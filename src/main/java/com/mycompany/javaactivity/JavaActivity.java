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
    
    
    //Function that displays the main menu
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
        
        String productName;
        int productPrice=0;
        int productID = 0;
        int removeProduct;
        String answer;
        boolean isValid=true;
        
        
        int orderProduct;
        int orderQuantity = 0;
        int totalPrice;
        boolean isValid2=true;
        boolean isValid3=true;
        
        String orderReference;

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
                //Admin Side
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
                                //Admin Side for managing products
                                if(adminChoice==1){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      PRODUCTS       *");
                                    System.out.println("***********************");

                                    System.out.println("ID \t Name \t Price");

                                    if (productsAvailable.isEmpty()){
                                        System.out.println("  No Products Found.");
                                    }
                                    else{ 
                                        //Printing all products from the shop
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

                                    //Admin side for adding a product 
                                    if (manageProductChoice==1){
                                        System.out.println("\n\n***********************");
                                        System.out.println("*     ADD PRODUCT     *");
                                        System.out.println("***********************");

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
                                        
                                        //Add the products to the shop
                                        Product newProduct = new Product(productName, productID, productPrice);
                                        productsAvailable.add(newProduct);
                                        System.out.println("Product added successfully!");
                                    }
                                    //Admin side for removing a product
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
                                                    //Removing products from the shop
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
                                //Admin side for managing orders
                                else if(adminChoice==2){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*       ORDERS       *");
                                    System.out.println("***********************");

                                    System.out.println("Date \t\t\t\t Reference \t Name \t\t Price \t\t Quantity \t Total \t\t Status");
                                    
                                    if (customerOrders.isEmpty()){
                                        System.out.println("  No Orders Found.");
                                    }
                                    else{ 
                                        //Printing customer's orders
                                        for(Order order: customerOrders){
                                            System.out.println(order.getOrderDate() + "\t " + order.getReference() +"\t\t" + order.getProductName() + "\t" 
                                            + order.getProductPrice() + "\t\t" + order.getProductQuatity() + "\t" + order.getTotalPrice() + "\t\t" + order.getOrderStatus());
                                        }
                                    }
                                    
                                    System.out.println("........................");
                                    System.out.println("1 - Mark Order as Delivered");
                                    System.out.println("0 - Back\n");
                                    System.out.print("What do you want to do? : ");
                                    manageProductChoice = console.nextInt();
                                    
                                    //Admin side for marking product as delivered
                                    if (manageProductChoice==1){

                                        do{
                                            try{
                                                if(customerOrders.isEmpty()){
                                                    System.out.print("No products found. Nothing to update here.");
                                                    isValid=false;
                                                    break;
                                                }
                                                System.out.println("\n\n***********************");
                                                System.out.println("* UPDATE ORDER STATUS *");
                                                System.out.println("***********************");

                                                System.out.print("Order Reference: " );
                                                orderReference = console.next();
                                                
                                                //Finding the order by reference from the list of orders
                                                Order thisOrder = orderService.findOrder(orderReference);

                                                if(thisOrder== null){
                                                    System.out.print("\nOrder does not exist. Please try again.");
                                                    isValid=false;
                                                    break;
                                                }
                                                
                                                System.out.print("\nAre you sure you want to mark this order as delivered? (Y/N): ");
                                                answer = console.next();

                                                if (answer.equals("Y") || answer.equals("y")){
                                                    //Setting the order's status as delivered
                                                    thisOrder.setOrderStatus("DELIVERED");
                                                    System.out.print("\nOrder updated successfully!");
                                                    isValid=true;
                                                }
                                                else if ((answer.equals("N") || answer.equals("n"))){
                                                    System.out.print("\nAction Canceled");
                                                    isValid=true;
                                                }
                                                else{
                                                    System.out.println("\nInvalid input. Please try again");
                                                }
                                            }
                                            catch(Exception e){
                                                System.out.println("\nInvalid character. Please try again");
                                                isValid=false;
                                            }
                                        }
                                            while(!isValid);
                                    }                                    
                                    adminChoice=0;
                                }
                            }
                        }
                        //Customer side
                        else if (customerService.isACustomer(logInUser)){
                            customerService.showCustomerScreen();
                            customerChoice = console.nextInt();
                            roleChoice=customerChoice;
                            
                            while(customerChoice!=0){
                                //Customer side for shopping products
                                if (customerChoice==1){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      PRODUCTS       *");
                                    System.out.println("***********************");

                                    System.out.println("ID \t Name \t Price");
                                    
                                    if (productsAvailable.isEmpty()){
                                        System.out.println("  No Products Found.");
                                    }
                                    else{ 
                                        //Printing products from the shop
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
                                                System.out.print("\nNo products found. Nothing to delete here.");
                                                isValid=false;
                                                break;
                                            }
                                            else if((adminService.findProduct(orderProduct))== null){
                                                System.out.print("\nProduct not found. Please try again.");
                                                isValid=false;
                                                break;
                                            }
                                            
                                            //Finding and saving the product that the customer wants to order
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
                                                    System.out.println("\nInvalid Input. Please try again");
                                                    console.next();
                                                    isValid2=false;
                                                }
                                            }
                                            while(!isValid2);
                                            
                                            //Calculate total price of the order
                                            totalPrice = orderService.computeTotalPrice(product, orderQuantity);
                                            
                                            System.out.println("\nThat would be Php " + totalPrice);

                                            do{
                                                try{
                                                    System.out.print("Proceed with your order (Y/N): ");
                                                    answer = console.next();
                                                    
                                                    if (answer.equals("Y") || answer.equals("y")){
                                                        //Create order and set its attributes then add it to the list of orders
                                                        Order order = new Order(product.getProductName(), product.getProductID(), product.getProductPrice());
                                                        order.setOrderDate(orderService.generateOrderDate());
                                                        order.setReference(orderService.generateReferenceCode());
                                                        order.setOrderStatus("FOR_DELIVERY");
                                                        order.setProductQuatity(orderQuantity);
                                                        order.setTotalPrice(totalPrice);
                                                        customerOrders.add(order);
                                                        System.out.print("\nOrder placed successfully!");
                                                        isValid3=true;
                                                    }
                                                    else if ((answer.equals("N") || answer.equals("n"))){
                                                        System.out.print("\nAction Canceled");
                                                        isValid3=true;
                                                    }
                                                    else{
                                                        System.out.println("Invalid character. Please try again");
                                                        isValid3=false;
                                                    }
                                                }
                                                catch(Exception e){
                                                    System.out.println("Invalid Character. Please try again.");
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
                                //Customer side for checking orders
                                else if(customerChoice==2){
                                    System.out.println("\n\n***********************");
                                    System.out.println("*      MY ORDERS      *");
                                    System.out.println("***********************");

                                    System.out.println("Date \t\t\t\t Reference \t Name \t Price \t Quantity \t Total \t Status");
                                    
                                    if (customerOrders.isEmpty()){
                                        System.out.println("  No Orders Found.");
                                    }
                                    else{ 
                                        //Printing of customer's orders
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