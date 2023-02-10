package com.techelevator;

import com.techelevator.view.ProductItems;

public class Candy extends ProductItems {
    String soundEffects;

    public Candy(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, "Candy", numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        this.soundEffects = "Munch Munch, Mmm Mmm Good!";
        return soundEffects;
    }
}
