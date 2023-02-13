package com.techelevator.view;

import com.techelevator.Candy;
import com.techelevator.Gum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {
    private Gum gumTest;

    @Before
    public void beforeTest(){
        gumTest = new Gum("D1", "U-Chews", 0.85, "Gum");

    }

    @Test
    public void get_sound_effect_test() {
        String expected = "Chew Chew, Pop!";
        Assert.assertEquals(expected, gumTest.getSoundEffect());
    }
}
