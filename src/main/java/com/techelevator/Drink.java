package com.techelevator;

public class Drink extends ProductItem {

    private String soundEffect;

    public Drink(String code, String name, double price, String type) {
        super(code, name, price, "Drinks");
    }

    @Override
    public String getSoundEffect(){
        this.soundEffect = "Glug Glug, Chug Chug!";
        return this.soundEffect;
    }

}
