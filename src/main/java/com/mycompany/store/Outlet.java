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
public class Outlet extends Store{
    
    public void buy(long id, int quantity){
        boolean skip = false;
        int available = 1;
        for(int i = 0 ; i < getItems().size(); i++){
            if(getItems().get(i).getId() == id){
                for(int j = i + 1; j < getItems().size(); j++){
                    if(getItems().get(i).getId() != getItems().get(j).getId())
                        break;
                    available++;
                }
                if(quantity > available){
                    quantity = available;
                }
                for(int k = 0; k < quantity; k++)
                    getCart().add(getItems().remove(i));
                skip = true;
                break;
            }
        }
        if(!skip)
            System.out.println("Item not found");
    }

        public void receipt(double total){
        setTotalSale(getTotalSale() + total);
        ArrayList<Long> ids = new ArrayList();
        System.out.println("*********************************************************************************************");
        System.out.println("\t\t\tAnonymous Store");
        System.out.println(".............................................................................................");
        for(int i = 0; i < getCart().size(); i++){
            int quantity = 1;
            boolean skip = false;
            for(int j = 0; j < ids.size(); j++){
                if(ids.get(j).equals(getCart().get(i).getId()))
                    skip = true;
            }
            if(skip)
                continue;
                
            
            for(int j = i + 1; j < getCart().size(); j++){
                if(getCart().get(i).getId() == getCart().get(j).getId())
                    quantity++;
            }
            System.out.println(" " + getCart().get(i) + "     Quantity: " + quantity
            + "     Total Cost: " + getCart().get(i).getCost() * quantity);
            System.out.println(".............................................................................................");
            ids.add(getCart().get(i).getId());
        }
        System.out.println("   Total:  " + total);
        System.out.println("   Paid:   " + total);
        System.out.println("   Change:  -");
        System.out.println("*********************************************************************************************");
    }
    
    @Override
    public void instructions(){
            System.out.println("Press 1 for entering new product\n"+ "Press 2 for billing\n" 
                    + "Press 3 for checking stock\n" + "Press 4 for viewing total sale\n" + "Press 5 for exit");
        }
    
}
