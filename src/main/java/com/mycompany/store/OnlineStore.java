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
public class OnlineStore extends Store{
    ArrayList<Customer> customers;
    private boolean AdminAccess;
    private boolean login;

    public OnlineStore() {
        customers = new ArrayList<>();
        AdminAccess = false;
        login = false;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    
    public boolean isAdminAccess() {
        return AdminAccess;
    }

    public void setAdminAccess(boolean AdminAccess) {
        this.AdminAccess = AdminAccess;
    }
    
    public Customer registerCustomer(String name, String address, String emailAddress, String password, long phoneNumber){
        for(int i = 0; i < customers.size(); i++)
            if(emailAddress.equals(customers.get(i).getEmailAdress()) || emailAddress.equals("anonymousAdmin@gmail.com")){
                System.out.println("Email address already registered");
                return null;
            } 
        
        customers.add(new Customer(name,address,emailAddress,password,phoneNumber));
        System.out.println("Email registered");
        setLogin(true);
        return customers.get(customers.size() - 1);
    }
    
    public Customer login(String emailAddress, String password){
        if(emailAddress.equals("anonymousAdmin@gmail.com") && password.equals("admin123")){
            setAdminAccess(true);
            setLogin(true);
            return new Customer("admin", "asd", "anonymousAdmin@gmail.com", "admin123", 1235678L );
        }
        else{
            for(int i = 0; i < customers.size(); i++){
                if(customers.get(i).getEmailAdress().equals(emailAddress) && customers.get(i).getPassword().equals(password)){
                    System.out.println("Login successful");
                    setLogin(true);
                    return customers.get(i);
                }
            }
            
            System.out.println("Email or password incorrect");
            return null;

            
        }
    }
    
    @Override
    public void instructions(){
        if(isAdminAccess())
            System.out.println("Press 1 for viewing catalogue\n" + "Press 2 to make order\n" + "Press 3 for logging out\n"
                    + "Press 4 to exit\n" + "Press 5 for entering new product\n" + "Press 6 for viewing total sale");
        else
            System.out.println("Press 1 for viewing catalogue\n" + "Press 2 to make order\n" + "Press 3 for logging out\n" 
                    + "Press 4 for exit");
    }
    
}   
    
