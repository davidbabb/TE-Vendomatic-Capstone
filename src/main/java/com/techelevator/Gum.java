package com.techelevator;

import com.techelevator.view.ProductItems;

public class Gum extends ProductItems {

    public Gum(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, type, numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        String message = "Chew Chew, Pop!";
        return message;
    }
}
