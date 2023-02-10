package com.techelevator;

import com.techelevator.view.ProductItems;

public class Chips extends ProductItems {
    String soundEffects;

    public Chips(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, "Chips", numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        this.soundEffects = "Crunch Crunch, It's Yummy!";
        return soundEffects;
    }

}
