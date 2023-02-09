package com.techelevator;

import com.techelevator.view.ProductItems;

public class Candy extends ProductItems {
    public Candy(String name) {
        super(name);
    }

    @Override
    public String getSoundEffects(){
        String message = "Munch Munch, Mmm Mmm Good!";
        return message;
    }
}
