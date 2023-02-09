package com.techelevator;

import com.techelevator.view.ProductItems;

public class Chips extends ProductItems {
    public Chips(String name) {
        super(name);
    }

    @Override
    public String getSoundEffects(){
        String message = "Crunch Crunch, It's Yummy!";
        return message;
    }

}
