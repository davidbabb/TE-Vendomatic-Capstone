package com.techelevator;

import com.techelevator.view.ProductItems;

public class Chips extends ProductItems {

    private String soundEffect;

    public Chips(String code, String name, double price, String type) {
        super(code, name, price, "Chips");
    }

    @Override
    public String getSoundEffect(){
        this.soundEffect = "Crunch Crunch, It's Yummy!";
        return soundEffect;
    }

}
