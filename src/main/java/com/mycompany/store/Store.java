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
public abstract class Store {
    private ArrayList<Item> items;
    private ArrayList<Item> cart;
    private static double totalSale;

    public Store() {
        items = new ArrayList<>();
        cart = new ArrayList<>();
    }
    
    public static double getTotalSale() {
        return totalSale;
    }

    public static void setTotalSale(double totalSale) {
        Store.totalSale = totalSale;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }
    
    public void insert(String name,double price, long id, int quantity,  boolean print){
        boolean skip = false;
        if(!items.isEmpty()){
            for(int i = 0; i < items.size(); i++){              
                if(items.get(i).getName().compareTo(name) > 0){
                    for(int j = 0; j < quantity; j++)
                        items.add(i, new Item(name, price, id));
                    skip = true;
                    break;
                }
            }
            if(!skip)
                for(int k = 0; k < quantity; k++)
                    items.add(new Item(name, price, id));
        }
        
        else
            for(int l = 0; l < quantity; l++)
                items.add(new Item(name, price, id));             
          
        if(print)
            System.out.println("Item added to stock");
   }

    public void inStock(){             
        int quantity = 1;
        if(items.isEmpty())
            System.out.println("Nothing in stock");
        System.out.println("................................................................................");
        System.out.println("\t\t\tAnonymous Store");
        System.out.println("................................................................................");
        for(int i = 0; i < items.size(); i++){
            if(i == 0 || items.get(i).getId() != items.get(i - 1).getId()){
                System.out.print(items.get(i) + "     ");
                for(int j = i + 1;j < items.size(); j++)
                    if(items.get(i).getId() == items.get(j).getId())
                        quantity++;
                System.out.println("In stock: " + quantity);
                System.out.println("................................................................................");
                quantity = 1;
            }
        }
              
    }
    
    public abstract void instructions();
     
    
} 

