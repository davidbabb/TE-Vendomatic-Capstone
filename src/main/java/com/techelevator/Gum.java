package com.techelevator;

import com.techelevator.view.ProductItems;

public class Gum extends ProductItems {
    String soundEffects;

    public Gum(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, "Gum", numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        this.soundEffects = "Chew Chew, Pop!";
        return soundEffects;
    }
}
