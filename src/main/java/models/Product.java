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
    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    
}
