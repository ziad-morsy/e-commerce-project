/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;

/**
 *
 * @author zeyad
 */
public class Order {
    
    private int customerId;
    private int orderId;
    private Product products[];

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order() {
    }

    public Order(int customerId, int orderId, Product[] products) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.products = products;
    }
    
    public void printOrderInfo(Cart c) {
        System.out.println("Here's your order's summary:");
        System.out.println("Order ID: " + getOrderId());
        System.out.println("Customer ID: " + getCustomerId());
        System.out.println("Products:");
        for (Product product : products) {
            if(product == null) break;
            System.out.println("" + product.getName() + " - $" + product.getPrice());
        }
        System.out.println("Total Price: $" + c.calculatePrice());
    }
}
