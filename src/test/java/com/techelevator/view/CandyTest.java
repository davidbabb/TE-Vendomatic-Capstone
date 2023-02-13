package com.techelevator.view;

import com.techelevator.Candy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

    private Candy candyTest;

    @Before
    public void beforeTest(){
        candyTest = new Candy("B3"," Wonka Bar", 1.50, "Candy");

    }

    @Test
    public void get_sound_effect_test() {
        String expected = "Munch Munch, Mmm Mmm Good!";
        Assert.assertEquals(expected, candyTest.getSoundEffect());
    }
}
