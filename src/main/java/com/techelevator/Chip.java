package com.techelevator;

public class Chip extends ProductItem {

    private String soundEffect;

    public Chip(String code, String name, double price, String type) {
        super(code, name, price, "Chips");
    }

    @Override
    public String getSoundEffect(){
        this.soundEffect = "Crunch Crunch, It's Yummy!";
        return soundEffect;
    }

}
