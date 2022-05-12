package com.practice.practice;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends BankAccount {

    @Override
    public double doTransaction(double balance, String transactionType) {
       return super.doTransaction(5.0, "test");
    }
}
