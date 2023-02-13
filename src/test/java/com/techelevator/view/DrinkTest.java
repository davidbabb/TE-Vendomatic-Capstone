package com.techelevator.view;

import com.techelevator.Chip;
import com.techelevator.Drink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
    private Drink drinkTest;

    @Before
    public void beforeTest(){
        drinkTest = new Drink("C1", "Cola",1.25, "Drink");
    }

    @Test
    public void get_get_sound_test(){
        String expected = "Glug Glug, Chug Chug!";
        Assert.assertEquals(expected, drinkTest.getSoundEffect());
    }
}
