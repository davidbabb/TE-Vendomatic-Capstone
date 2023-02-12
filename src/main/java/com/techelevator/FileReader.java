package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private List<ProductItem> actualProducts = new ArrayList<>();

    public List CreateList() {

        String pathOfFile = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv";
        File readingFile = new File(pathOfFile);

        try (Scanner fileScanner = new Scanner(readingFile)) {

            int i = 0;

            while (fileScanner.hasNextLine()) {

                String s = fileScanner.nextLine();
                String[] arr = s.split("\\|");
                String code = arr[0];
                String product = arr[1];
                String price = arr[2];
                String type = arr[3];

                double doublePrice = Double.parseDouble(price);

                if (i < 4) {
                    Chip chips = new Chip(code, product, doublePrice, type);
                    actualProducts.add(chips);
                    i++;
                } else if (i < 8) {
                    Candy candy = new Candy(code, product, doublePrice, type);
                    actualProducts.add(candy);
                    i++;
                } else if (i < 12) {
                    Drink drink = new Drink(code, product, doublePrice, type);
                    actualProducts.add(drink);
                    i++;
                } else {
                    Gum gum = new Gum(code, product, doublePrice, type);
                    actualProducts.add(gum);
                    i++;
                }

            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        return actualProducts;

    }


}
