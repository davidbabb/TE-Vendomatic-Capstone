package com.techelevator;

import com.techelevator.view.ProductItems;

public class Drinks extends ProductItems {
    String soundEffects;

    public Drinks(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, "Drinks", numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        this.soundEffects = "Glug Glug, Chug Chug!";
        return this.soundEffects;
    }

}
