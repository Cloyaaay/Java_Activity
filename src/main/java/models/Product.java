/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author suyao
 */
public class Product {
    private String productName;
    private int productID;
    private int productPrice;
    
    public Product (){
        this.productName = "Default";
        this.productID = 0;
        this.productPrice = 0;
    }
    
    public Product(String productName, int productID, int productPrice){
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
    }
}
