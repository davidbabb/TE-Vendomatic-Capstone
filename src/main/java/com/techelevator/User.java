package com.techelevator;
import java.lang.IllegalArgumentException;
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

    public void subtractFromBalance(double amount){
        if(cashBalance >= amount){ // checks to see if the amount given by the user "cashBalance" is greater than amount we are looking to subtract from the cost of an item.
            cashBalance -= amount; //if it is then we subtract the amount and then the new cashBalance given
        } else {
            throw new IllegalArgumentException("Insufficient funds"); //if the cashBalance of the user is less then we use throw to have program say "Insufficient funds"
        }
    }

}
