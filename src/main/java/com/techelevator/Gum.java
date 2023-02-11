package com.techelevator;

import com.techelevator.view.ProductItems;

public class Gum extends ProductItems{

    private String soundEffect;

    public Gum(String code, String name, double price, String type) {
        super(code, name, price, "Gum");
    }

    public String getSoundEffect() {
        this.soundEffect = "Chew Chew, Pop!";
        return soundEffect;
    }
}
