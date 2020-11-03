/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

import java.util.Scanner;


/**
 *
 * @author Bassam Muhammad
 */
public class Customer {
    private String name;
    private String address;
    private String emailAdress;
    private String password;
    private long phoneNumber;
    
    
    public Customer(String name, String address, String emailAdress, String password, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.emailAdress = emailAdress;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void makeOrder(OnlineStore online){
        Order order = new Order();
        order.instructions();
        Scanner input = new Scanner(System.in);
        int orderChoice = Integer.parseInt(input.nextLine());
        boolean bought = false;
        while(orderChoice != 6){
            switch(orderChoice){
                //Put products in cart
                case 1:
                    while(true){
                        System.out.println("Enter product id and quantity");
                        order.putInCart(Long.parseLong(input.nextLine()), Integer.parseInt(input.nextLine()), online);
                        System.out.println("Enter next product?\nPress 1 for Yes, 2 for No");
                        orderChoice = Integer.parseInt(input.nextLine());
                        if(orderChoice == 2)
                            break;
                    }
                    break;
              
                //Show products added to cart
                case 2:
                    System.out.println("******");
                    System.out.println("Cart:");
                    System.out.println("******");
                    order.showCart();
                    break;
                            
                //Remove product from cart
                case 3:
                    System.out.println("Enter id of product");
                    order.removeFromCart(Integer.parseInt(input.nextLine()), online);
                    break;

                //emty cart
                case 4:
                    order.emptyCart(online);
                    break;
                            
                //Purchasing
                case 5:
                    System.out.println("*********");
                    System.out.println("Billing:");
                    System.out.println("*********");    
                    order.buy();
                    bought = true;
                    break;
            
            }
            if(bought)
                break;
            order.instructions();
            orderChoice = Integer.parseInt(input.nextLine());
            if(orderChoice == 6 && !order.cart.isEmpty()){
                for(int i = 0; i < order.cart.size(); i++)
                    online.insert(order.cart.get(i).getName(), order.cart.get(i).getCost(), order.cart.get(i).getId(), 1, false);
                
            }
        
        }
    }
}
