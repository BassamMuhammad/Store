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
public class Card extends Payment{
    private long cardNumber;
    private int PIN;
  
    public Card(){
        this.cardNumber = 1023456789101112L;
        this.PIN = 1234;
    }
    
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }
    
    @Override
    public void makePayment(double cost){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 4-digit PIN");
        int pin = Integer.parseInt(input.nextLine());
        while(true){                                            
            if(pin == getPIN()){
                setBalance(getBalance() - cost);
                break;  
            }
            else{
                System.out.println("PIN is not correct!\nEnter again");
                pin = Integer.parseInt(input.nextLine());
            }
            
        }
    }

}
