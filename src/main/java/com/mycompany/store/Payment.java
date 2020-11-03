/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

/**
 *
 * @author Bassam Muhammad
 */
public abstract class Payment {
    private double balance;

    public Payment() {
        this.balance = 100000000.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void makePayment(double cost);
    
}
