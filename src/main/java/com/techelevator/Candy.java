package com.techelevator;

import com.techelevator.view.ProductItems;

public class Candy extends ProductItems {

    public Candy(String code, String name, double price, String type, int numberOfItems) {
        super(code, name, price, type, numberOfItems);
    }

    @Override
    public String getSoundEffects(){
        String message = "Munch Munch, Mmm Mmm Good!";
        return message;
    }
}
