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
public class Online extends Payment{
    private Card onlinePay;

    public Online(Card onlinePay) {
        this.onlinePay = onlinePay;
    }
  
    public Card getOnlinePay() {
        return onlinePay;
    }

    public void setOnlinePay(Card onlinePay) {
        this.onlinePay = onlinePay;
    }
    public boolean verification(int pin , long cardNumber){
        return pin == onlinePay.getPIN() && cardNumber == onlinePay.getCardNumber();
    }
      
    @Override
    public void makePayment(double cost){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Card Number and then PIN");
        long cardNumber = Long.parseLong((input.nextLine()));
        int pin = Integer.parseInt(input.nextLine());
        while(!verification(pin, cardNumber)){
          System.out.println("Wrong!! Enter Card Number and then PIN");
          cardNumber = Long.parseLong((input.nextLine()));
          pin = Integer.parseInt(input.nextLine());  
        }
        setBalance(getBalance() - cost);
    }
}
