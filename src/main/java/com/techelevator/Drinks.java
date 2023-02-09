package com.techelevator;

import com.techelevator.view.ProductItems;

public class Drinks extends ProductItems {
    public Drinks(String name) {
        super(name);
    }

    @Override
    public String getSoundEffects(){
        String message = "Glug Glug, Chug Chug!";
        return message;
    }

}
