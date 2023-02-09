package com.techelevator;

import com.techelevator.view.ProductItems;

public class Gum extends ProductItems {

    public Gum(String name) {
        super(name);
    }
    @Override
    public String getSoundEffects(){
        String message = "Chew Chew, Pop!";
        return message;
    }
}
