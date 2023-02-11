package com.techelevator;

import com.techelevator.ProductCount;

import java.util.Scanner;

public abstract class ProductItems{

    Scanner userInput = new Scanner(System.in); //Taking in user input for main menu
    private String code;
    private String name;
    private double price;
    private String type;
    private int numberOfItems;
    private String soundEffect;

    public ProductItems(String code, String name, double price, String type){

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

    public static ProductCount getSnackByItemCode(String code){ //creating a method to creat an array of ProductCount objects which start off empty [0].
        ProductCount[] productList = new ProductCount[0]; //initialize array with empty amount
        for(ProductCount product : productList){ //iterates thru the productList array with and Enhanced for each loop
            if (product.getCode().equals(code)){ //checks to see if the code of the current product object is equal to the code passed through in the argument
                return product;// if they match return the current product object
            }
        }
        return null; //otherwise return null
    }

    public void reduceItemQuantityByOne(){ //made a method to reduce the number of items in inventory by 1 if method is called.
        if (numberOfItems > 0) {
            numberOfItems --;
        }
    }

    public void SubtractItem() {
        this.numberOfItems = numberOfItems - 1;
    }


}
