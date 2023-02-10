package com.techelevator;

import com.techelevator.view.ProductItems;

public class Chips extends ProductItems {

    public Chips(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, type, numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        String message = "Crunch Crunch, It's Yummy!";
        return message;
    }

}
