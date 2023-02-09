package com.techelevator.view;

import java.util.Scanner;

public class ProductItems {



    Scanner userInput = new Scanner(System.in); //Taking in user input for main menu
    private String name = new String();
    private int price;
    private String soundEffects;
    private int numberOfItems;





    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSoundEffects() {
        return soundEffects;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
    public ProductItems(String name){
        this.name = name;

    }


}
