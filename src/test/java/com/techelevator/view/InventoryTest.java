package com.techelevator.view;

import com.techelevator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class InventoryTest {
    private Inventory inventoryTest;
    private ProductItem item;
    Scanner scanner = new Scanner(System.in);

    @Before
    public void BeforeTest() {
        inventoryTest = new Inventory();
    }

    @Test
    public void display_balance_test_1() {
        inventoryTest.setCashBalance(10);
        String expected = "Your total balance is $10.00";
        Assert.assertEquals(expected, inventoryTest.DisplayBalance());
    }

    @Test
    public void display_balance_test_2() {
        inventoryTest.setCashBalance(-10);
        String expected = "Your total balance is $0.00";
        Assert.assertEquals(expected, inventoryTest.DisplayBalance());
    }

    @Test
    public void feed_money_test_1() {
        String value = "20";
        double cash = Double.parseDouble((value));
        inventoryTest.setCashBalance(0 + cash);
        Assert.assertEquals(20, inventoryTest.getCashBalance(), 0);
    }

    @Test
    public void feed_money_test_2() {
        String value = "-10";
        double cash = Double.parseDouble((value));
        inventoryTest.setCashBalance(0 + cash);
        Assert.assertEquals(0, inventoryTest.getCashBalance(), 0);
    }

    @Test
    public void subtract_from_balance_test() {
        double number = 3;
        inventoryTest.setCashBalance(10);
        inventoryTest.SubtractFromBalance(number);
        Assert.assertEquals(7, inventoryTest.getCashBalance(), 0);
    }

    @Test
    public void dispense_item_test_1() {
        ProductItem item = new Chip("A1", "Potato Crisps", 3.05, "Chip");
        Assert.assertEquals("Dispensing Potato Crisps... Great choice!" + "\n" + item.getSoundEffect(), inventoryTest.DispenseItem(item));
    }

    @Test
    public void dispense_item_test_2() {
        ProductItem item = new Gum("D1", "U-Chews", 0.85, "Gum");
        Assert.assertEquals("Dispensing U-Chews... Great choice!" + "\n" + item.getSoundEffect(), inventoryTest.DispenseItem(item));
    }

    @Test
    public void finish_transaction_test() {
        double endBalance = 0.00;
        inventoryTest.setCashBalance(10);
        inventoryTest.FinishTransaction();
        Assert.assertEquals(0.00, inventoryTest.getCashBalance(), 0);
    }

    @Test
    public void subtract_from_inventory_test_1() {
        ProductItem item = new Candy("B1", "Moonpie", 1.80, "Candy");
        inventoryTest.SubtractFromInventory(item);
        Assert.assertEquals(4, item.getNumberOfItems());
    }

    @Test
    public void get_cash_balance_getter_setter_test() {
        inventoryTest.setCashBalance(493029403290.0);
        Assert.assertEquals(493029403290.0, inventoryTest.getCashBalance(), 0);
    }

}
