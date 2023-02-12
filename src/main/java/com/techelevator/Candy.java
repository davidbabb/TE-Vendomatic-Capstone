package com.techelevator;

public class Candy extends ProductItem {

    private String soundEffect;

    public Candy(String code, String name, double price, String type) {
        super(code, name, price, "Candy");
    }

    @Override
    public String getSoundEffect(){
        this.soundEffect = "Munch Munch, Mmm Mmm Good!";
        return soundEffect;
    }

}
