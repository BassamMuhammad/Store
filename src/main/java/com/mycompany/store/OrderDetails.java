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
public class OrderDetails {
    ArrayList<Item> order = new ArrayList<>();
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void showOrder(){
        ArrayList<Long> ids = new ArrayList<>();
        System.out.println("*********************************************************************************************");
        System.out.println("\t\t\tAnonymous Store");
        System.out.println(".............................................................................................");
        for(int i = 0; i < order.size(); i++){
            int quantity = 1;
            boolean skip = false;
            for(int j = 0; j < ids.size(); j++){
                if(ids.get(j).equals(order.get(i).getId()))
                    skip = true;
            }
            if(skip)
                continue;
            ids.add(order.get(i).getId());
            
            for(int j = i + 1; j < order.size(); j++){
                if(order.get(i).getId() == order.get(j).getId())
                    quantity++;
            }
            System.out.println(" " + order.get(i) + "     Quantity: " + quantity
            + "     Total Cost: " + order.get(i).getCost() * quantity);
            System.out.println(".............................................................................................");
        }
        System.out.println(".............................................................................................");
        System.out.println("   Total:  Rs." + getTotal());
        System.out.println("   Paid:   Rs." + getTotal());
        System.out.println("   Change:  -");
        System.out.println("*********************************************************************************************");

        
    }

}
