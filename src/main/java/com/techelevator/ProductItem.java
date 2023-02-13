package com.techelevator;

import java.util.Scanner;

public abstract class ProductItem {

    Scanner userInput = new Scanner(System.in); //Taking in user input for main menu
    private String code;
    private String name;
    private double price;
    private String type;
    private int numberOfItems;
    private String soundEffect;
    private int initialQuantity;

    public ProductItem(String code, String name, double price, String type){

        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.numberOfItems = 5;

    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getSoundEffect() {
        return soundEffect;
    }


    public void SubtractItem() {
        this.numberOfItems = numberOfItems - 1;
    }


    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getRemainingQuantity() {
        return initialQuantity - numberOfItems;
    }

}
