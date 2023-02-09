package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class Display {

    public void DisplayMenu(File file){
        try (Scanner fileScanner = new Scanner(file)){
            System.out.printf("\n%-5s %-20s %-15s \n\n", "ID", "Product", "Price");

            while (fileScanner.hasNextLine()){
                String s = fileScanner.nextLine();
                int barOne = s.indexOf("|");
                int barTwo = s.indexOf("|", barOne + 1);
                int barThree = s.lastIndexOf("|");
                String code = s.substring(0, barOne);
                String product = s.substring(barOne + 1, barTwo);
                String price = "$" + s.substring(barTwo + 1, barThree);
                String type = s.substring(barThree, s.length());
                System.out.printf("%-5s %-20s %-15s \n", code, product, price, type);
            }
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public void DisplayPurchaseMenu(){
        String feedMoney = "(1) Feed Money";
        String selectProduct ="(2) Select Product";
        String finishTransaction = "(3) Finish Transaction";
        System.out.println(feedMoney + "\n" + selectProduct + "\n" + finishTransaction);

    }



}
