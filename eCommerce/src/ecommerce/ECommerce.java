/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ecommerce;
import java.util.Scanner;


/**
 *
 * @author zeyad
 */
public class ECommerce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ElectronicProduct p1 = new ElectronicProduct("smartphone", 1, 599.9f, "Samsung", 1);
        ClothingProduct p2 = new ClothingProduct("T-shirt", 2, 19.99f, "Medium", "Cotton");
        BookProduct p3 = new BookProduct("OOP", 3, 39.99f, "O'Reilly", "X Publications");
        Customer c1 = new Customer();
        Cart cart = new Cart();
        
        
        System.out.println("Welcome to the E-Commerce System!");
        System.out.println("Enter your ID: ");
        
        //String temp ="";
        //int temp2 = 0;
        Scanner input = new Scanner(System.in);
        int temp2 = input.nextInt();
        c1.setCutomerId(temp2);
        
        System.out.println("Enter your name: ");
        String temp = input.next();
        c1.setName(temp);
        
        System.out.println("Enter your adress: ");
        temp = input.next();
        c1.setAddress(temp);
        
        System.out.println("How many products you want to add to your cart?");
        temp2 = input.nextInt();
        cart.setnProducts(temp2);
        
        Product[] arr = new Product[cart.getnProducts()];
        cart.setProducts(arr);
        
        for(int i=0; i<cart.getnProducts(); i++) {
            System.out.println("Wich product would you like to add? 1- " + p1.getName() + " 2- " + p2.getName() + " 3- " +p3.getName());
            int t = input.nextInt();
            switch (t){
                case 1:
                    cart.addProduct(p1, i);
                    System.out.println(p1.getName() + " Added to Cart!");
                    break;
                case 2:
                    cart.addProduct(p2, i);
                    System.out.println(p2.getName() + " Added to Cart!");
                    break;
                case 3:
                    cart.addProduct(p3, i);
                    System.out.println(p3.getName() + " Added to Cart!");
                    break;
                default:
                    System.out.println("Product Not Found!");
                    i--;
                    break;     
            }                   
         }
        
        
        
        boolean p = true;
        while (p) {
            System.out.println("Your Total is $" + cart.calculatePrice());
            if(cart.placeOrder()){
                Order order = new Order(c1.getCutomerId(), 1, cart.getProducts());

                order.printOrderInfo(cart);
                p = false;
            }
            else {
                System.out.println("Wich product would you like to remove? 1- " + p1.getName() + " 2- " + p2.getName() + " 3- " +p3.getName());

                int t = input.nextInt();
                switch (t){
                    case 1:
                        cart.removeProduct(p1);
                        break;
                    case 2:
                        cart.removeProduct(p2);
                        break;
                    case 3:
                        cart.removeProduct(p3);
                        break;
                    default:
                        System.out.println("Product Not Found!");               
                        break;

                }
            }
        }     
    } 
}
