package com.techelevator;

import java.util.Scanner;

public class User {
    private double cashBalance;



    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void DisplayBalance(){
        System.out.println("\n" + "Your total balance: " + "$" + getCashBalance());
    }

    public void FeedMoney() {

        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "Please insert cash amount >>> ");
        String value = input.nextLine();
        double cash = Double.parseDouble((value));
        this.cashBalance = getCashBalance() + (double) cash;
        DisplayBalance();

    }
}
