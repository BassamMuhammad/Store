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
public class Testing {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice = 0;
        //select version - outlet/online
        while(choice != 1 && choice != 2){
            System.out.println("Press 1 to use outlet version, 2 to use online version");
            choice = Integer.parseInt(input.nextLine());
        }
        
        //Testing outlet
        if(choice == 1){
            Outlet outlet = new Outlet();
            outlet.instructions();
            int outletChoice = Integer.parseInt(input.nextLine());
            while(outletChoice != 5){
                switch(outletChoice){
                    //Adding products to system
                    case 1:
                        System.out.println("*****************");
                        System.out.println("Adding products:");
                        System.out.println("*****************");
                        while(outletChoice == 1){    
                            System.out.println("Enter product name and then its price, id and quantity:");
                            String name = input.nextLine();
                            double price = Double.parseDouble(input.nextLine());
                            long id = Long.parseLong(input.nextLine());
                            int quantity = Integer.parseInt(input.nextLine());
                            outlet.insert(name, price, id, quantity,true);
                            System.out.println("Enter next product?\nPress 1 for Yes, 2 for No");
                            outletChoice = Integer.parseInt(input.nextLine());
                        }

                        break;
                    //Removig product from system(i.e purchasing)
                    case 2:
                        System.out.println("*********");
                        System.out.println("Billing:");
                        System.out.println("*********");    
                        double total =0;
                        outletChoice = 1;
                        while(outletChoice == 1){       //loop until all products are purchased
                            System.out.println("Enter product id and quantity");
                            Long id = Long.parseLong(input.nextLine());
                            int quantity = Integer.parseInt(input.nextLine());
                            outlet.buy(id, quantity);
                            outletChoice = -1;
                            while(outletChoice != 1 && outletChoice != 2){          //loop until 1 or 2
                                System.out.println("Enter next product?\nPress 1 for Yes, 2 for No");
                                outletChoice = Integer.parseInt(input.nextLine());
                            }
                        }
                        for(int i = 0; i < outlet.getCart().size(); i++)
                            total += outlet.getCart().get(i).getCost();
                        if(total == 0){
                            System.out.println("Nothing bought");
                            break;
                        }                            
                        System.out.println("Please pay: " + total); 
                        int paymentMethod = 0;
                        while(paymentMethod != 1 && paymentMethod != 2){
                            System.out.println("Choose payment option\n"
                                    + "Press 1 for CASH, 2 for CARD");
                            paymentMethod = Integer.parseInt(input.nextLine());
                        }
                        switch(paymentMethod){
                            //Pay with cash
                            case 1:
                                Cash cash = new Cash();
                                cash.makePayment(total);
                                outlet.receipt(total);
                                outlet.getCart().clear();
                                break;
                            //Pay with card 
                            case 2:
                                Card card = new Card();
                                card.makePayment(total);
                                outlet.receipt(total);
                                outlet.getCart().clear();
                                break;
                        }                    
                        break;
                        
                    //see products in stock
                    case 3:
                        System.out.println("*******");
                        System.out.println("Stock:");
                        System.out.println("*******");
                        outlet.inStock();  
                        break;
                      
                    //see total sale for day(one program execution)
                    case 4:
                        System.out.println();
                        System.out.println("Total sale is: " + Outlet.getTotalSale());
                        System.out.println();
                        break;

                }
                outlet.instructions();   
                outletChoice = Integer.parseInt(input.nextLine());
            }
        }
        
        //Testing online store
        else if(choice == 2){
            OnlineStore online = new OnlineStore();
            Customer customer;
            while(true){                        //allow user to sign in with other accont
                while(true){       //loop until user doesn't log-on
                    int registeration = 0;
                    while(registeration != 1 && registeration != 2){    
                        System.out.println("Enter 1 to register, 2 to login");
                        registeration = Integer.parseInt(input.nextLine());
                    }
                    if(registeration == 1){     //register uer
                        System.out.println("Enter your name, address, email address, password and phone number");
                        customer = online.registerCustomer(input.nextLine(), input.nextLine(), input.nextLine(),
                                input.nextLine(), Long.parseLong(input.nextLine()));
                    }
                    else{                       //login
                        System.out.println("Enter your email address and password");
                        customer = online.login(input.nextLine(), input.nextLine());
                    } 
                    if(online.isLogin())
                        break;
                }
                online.instructions();
                int onlineChoice = Integer.parseInt(input.nextLine());
                while(onlineChoice != 4){
                    switch(onlineChoice){
                        //Products in stock
                        case 1:
                            System.out.println("**********");
                            System.out.println("Catalogue:");
                            System.out.println("**********");
                            online.inStock();
                            break;
                            
                        case 2:
                            System.out.println("************");
                            System.out.println("Make order:");
                            System.out.println("************");
                            customer.makeOrder(online);
                            break;
                           
                        //log - off
                        case 3:
                            online.setLogin(false);
                            online.setAdminAccess(false);
                            break;
                            
                        //Add products to system
                        case 5:
                            
                            if(!online.isAdminAccess())         //allow only admin to add products
                                break;
                            System.out.println("*****************");
                            System.out.println("Adding products:");
                            System.out.println("*****************");
                            onlineChoice = 1;
                            while(onlineChoice == 1){    
                                System.out.println("Enter product name and then its price, id and quantity:");
                                String name = input.nextLine();
                                double price = Double.parseDouble(input.nextLine());
                                long id = Long.parseLong(input.nextLine());
                                int quantity = Integer.parseInt(input.nextLine());
                                online.insert(name, price, id, quantity, true);
                                System.out.println("Enter next product?\nPress 1 for Yes, 2 for No");
                                onlineChoice = Integer.parseInt(input.nextLine());
                            }
                            break;

                        //Check total sale for day(one program execution)
                        case 6:
                            if(!online.isAdminAccess())         //allow only admin to check total sale
                                break;
                            System.out.println();
                            System.out.println("Total sale is: Rs." + OnlineStore.getTotalSale());
                            System.out.println();
                            break;

                    }
                    if(onlineChoice == 3)       //check to see if user logged - off
                        break;
                    online.instructions();   
                    onlineChoice = Integer.parseInt(input.nextLine());
                }
                if(onlineChoice == 4)           //check to see if user want to exit
                    break;
            }
        }
        
    }           
    
}
