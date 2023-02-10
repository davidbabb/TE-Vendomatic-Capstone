package com.techelevator;

import com.techelevator.view.ProductItems;

public class Drinks extends ProductItems {

    public Drinks(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, type, numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        String message = "Glug Glug, Chug Chug!";
        return message;
    }

}
