package com.techelevator.view;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductItems {

    Scanner userInput = new Scanner(System.in); //Taking in user input for main menu
    private String name = new String();
    private int price;
    private String soundEffects;
    private int numberOfItems;

    public ProductItems(String name){
        this.name = name;

    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSoundEffects() {
        return soundEffects;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }


//    public void GetProducts(File file) {
//
//        try (Scanner fileScanner = new Scanner(file)) {
//            System.out.printf("\n%-5s %-20s %-15s \n\n", "ID", "Product", "Price");
//
//            while (fileScanner.hasNextLine()) {
//                String s = fileScanner.nextLine();
//                int barOne = s.indexOf("|");
//                int barTwo = s.indexOf("|", barOne + 1);
//                String code = s.substring(0, barOne);
//                String product = s.substring(barOne + 1, barTwo);
//
//            }
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//
//    }


}
