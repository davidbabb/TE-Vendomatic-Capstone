package com.techelevator;

import com.techelevator.view.ProductItems;

public class Drinks extends ProductItems {

    private String soundEffect;

    public Drinks(String code, String name, double price, String type) {
        super(code, name, price, "Drinks");
    }

    @Override
    public String getSoundEffect(){
        this.soundEffect = "Glug Glug, Chug Chug!";
        return this.soundEffect;
    }

}
