package com.techelevator.view;

import com.techelevator.VendingMenu;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuMethodTest {

    private InputStream input;
    private OutputStream output;
    private Scanner in;
    private PrintWriter out;

    @Before
    public void BeforeTest() {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    @Test
    public void DisplayBalanceTest() {

        VendingMenu menu = new VendingMenu(input, output);

    }

}
