package com.techelevator;

public class User {
    private int cashBalance;



    public int getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void DisplayBalance(){
        System.out.println("Your total balance: " + "$" + getCashBalance());
    }
}
