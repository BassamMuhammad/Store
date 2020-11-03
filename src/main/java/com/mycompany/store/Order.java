/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

import java.util.ArrayList;

/**
 *
 * @author Bassam Muhammad
 */
public class Order {

    ArrayList<Item> cart = new ArrayList<>();
    OrderDetails details = new OrderDetails();
        
    public void showCart(){
        ArrayList<Long> ids = new ArrayList<>();
        if(cart.isEmpty())
            System.out.println("Cart is empty");
        else{
            System.out.println(".............................................................................................");
            for(int i = 0; i < cart.size(); i++){               
                int quantity = 1;
                boolean skip = false;
                for(int j = 0; j < ids.size(); j++){
                    if(ids.get(j).equals(cart.get(i).getId()))
                        skip = true;
                }
                if(skip)
                    continue;
                
                ids.add(cart.get(i).getId());
            
                for(int j = i + 1; j < cart.size(); j++){
                    if(cart.get(i).getId() == cart.get(j).getId())
                        quantity++;
                }
                System.out.println(" " + cart.get(i) + "     Quantity: " + quantity
                + "     Total Cost: " + cart.get(i).getCost() * quantity);
                System.out.println(".............................................................................................");
            }
        }
        
    }

    public void putInCart(long id, int quantity, OnlineStore online){
        boolean found = false;
        int available = 1;
        for(int i = 0; i < online.getItems().size(); i++){
            if(online.getItems().get(i).getId() == id){
                for(int j = i + 1; j < online.getItems().size(); j++){
                    if(online.getItems().get(i).getId() != online.getItems().get(j).getId())
                        break;
                    available++;
                }
                if(quantity > available)
                    quantity = available;
                for(int k = 0; k < quantity; k++)
                    cart.add(online.getItems().remove(i));
                System.out.println("Item added in cart");
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("Item not found");
    }
        
    public void removeFromCart(long id, OnlineStore online){
        if(!cart.isEmpty()){
            boolean found = false;
            for(int i = 0; i < cart.size(); i++){
                if(cart.get(i).getId() == id){
                   Item item = cart.remove(i);
                   online.insert(item.getName(), item.getCost(), item.getId(), 1, false);
                   found = true;
                   break;
                }
            }
            if(found)
                System.out.println("Item removed from cart");
            else
                System.out.println("Item not found");
        }
        else
            System.out.println("Cart is empty");
    }
    
    public void emptyCart(OnlineStore online){
        while(!cart.isEmpty()){
            Item item = cart.remove(0);
            online.insert(item.getName(), item.getCost(), item.getId(), 1, false);
        }
        System.out.println("Cart emptied");
    }
    
    public void buy(){         
        if(cart.isEmpty())
            System.out.println("Cart is empty");
        else{
            while(!cart.isEmpty()){
                details.setTotal(details.getTotal() + cart.get(0).getCost());
                details.order.add(cart.remove(0));
            }
            Online onlinePayment = new Online(new Card());
            onlinePayment.makePayment(details.getTotal());
            details.showOrder();
            OnlineStore.setTotalSale(OnlineStore.getTotalSale() + details.getTotal());
        }
    }
    
    public void instructions(){
        System.out.println("Press 1 for adding products in cart\n" + "Press 2 for seeing cart\n" + "Press 3 for removing from cart\n"
                + "Press 4 to empty cart\n" + "Press 5 for buying\n" + "Press 6 to exit order");
    }
    
}
