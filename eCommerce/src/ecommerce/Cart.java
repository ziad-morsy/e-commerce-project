/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;
import java.util.Scanner;
//import java.util.ArrayList;
/**
 *
 * @author zeyad
 */
public class Cart {
    private int customerId;
    private int nProducts;
    private Product products[] = new Product[nProducts];

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    
    
    public Cart() {
    }
    
    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        this.products = new Product[nProducts];
    }
    
     public void addProduct(Product p, int i) {
         products[i] = p;
    }
    
     public void removeProduct(Product p) {
        for(int i=0; i<nProducts; i++) {
            if(products[i] == p) {
                for(int j=i; j<nProducts-1; j++) {
                    products[j] = products[j+1];
                }
                products[nProducts-1] = null;
                nProducts--;
                System.out.println(""+p.getName()+" Removed Successfuly !");
                return;   
            }        
        }
        System.out.println(""+p.getName()+" is NOT found in cart !");
     }
     
     public float calculatePrice() {
         float total = 0;
         for(int i=0; i<nProducts; i++) {
             total += products[i].getPrice();
         }
         return total;
     }
     
     public boolean placeOrder() {
         Scanner input = new Scanner(System.in);
         while(true){
            System.out.println("Would you like to place an order? 1- Yes 2- No");
            int n = input.nextInt();
            if(n == 1) return true;
            if(n == 2) return false;
         }
     }
}
