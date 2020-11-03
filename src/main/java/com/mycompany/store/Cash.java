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
public class Cash extends Payment{

    @Override
    public void makePayment(double cost){
        setBalance(getBalance() - cost);
    }
          
}
