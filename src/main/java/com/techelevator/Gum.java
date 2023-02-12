package com.techelevator;

public class Gum extends ProductItem {

    private String soundEffect;

    public Gum(String code, String name, double price, String type) {
        super(code, name, price, "Gum");
    }

    public String getSoundEffect() {
        this.soundEffect = "Chew Chew, Pop!";
        return soundEffect;
    }
}
