package com.techelevator.view;

import com.techelevator.Chip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {
    private Chip chipTest;

    @Before
    public void beforeTest(){
        chipTest = new Chip("A1", "PotatoCrisps", 3.05, "Chip");
    }

    @Test
    public void get_get_sound_test(){
        String expected = "Crunch Crunch, It's Yummy!";

        Assert.assertEquals(expected, chipTest.getSoundEffect());
    }

}
