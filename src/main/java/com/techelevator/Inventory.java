package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private FileReader readerInstance = new FileReader();
    private double cashBalance;
    private double totalMoney;
    private List <ProductItem> products = readerInstance.CreateList();
    private List <String> listOfCodes = new ArrayList<>();

    public Inventory () {
        this.products = products;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {

        if (cashBalance > 0) {
            this.cashBalance = cashBalance;
        } else {
            this.cashBalance = 0;
        }
    }

    public String DisplayBalance(){
        String displayBalance = "Your total balance is " + "$" + String.format("%.2f", getCashBalance());
        System.out.println("\n" + displayBalance);
        return displayBalance;
    }

    public void DisplayMenu() {

        System.out.printf("\n%-5s %-20s %-10s %-5s \n\n", "ID", "Product", "Price", "Quantity");

        for (ProductItem actualProduct : products) {

            System.out.printf("%-5s %-20s %-10s %-5s \n", actualProduct.getCode(), actualProduct.getName(), ("$" + String.format("%.2f", actualProduct.getPrice())), actualProduct.getNumberOfItems());

        }

    }

    public void SelectProduct() throws SoldOut {

        DisplayMenu();
        Scanner input = new Scanner(System.in); //initializes a scanner to take in user input of item code
        System.out.println("\nEnter product code: "); // asks user for item code
        String productCode = input.nextLine().toUpperCase(); //forces all input to Upper casing matching the .csv file
        double itemPrice = 0.00;
        double currentBalance = 0.00;
        CreateListOfCodes();

        for (int i = 0; i < products.size(); i++) {

            try {

                if (productCode.equals(products.get(i).getCode())) {

                    if (products.get(i).getNumberOfItems() > 0) {

                        itemPrice = products.get(i).getPrice();
                        currentBalance = getCashBalance();
                        SubtractFromBalance(itemPrice);

                        if (itemPrice < currentBalance) {

                            DispenseItem(products.get(i));
                            SubtractFromInventory(products.get(i));
                            CreateLog(products.get(i).getName() + " " + products.get(i).getCode(), products.get(i).getPrice());

                        }

                    } else {

                        throw new Inventory.SoldOut();

                    }

                } else if (!listOfCodes.contains(productCode)) {

                    System.out.println("\nINVALID PRODUCT CODE. PLEASE TRY AGAIN.");
                    break;

                }

            } catch (SoldOut e) {

                System.out.println("\nITEM IS SOLD OUT, PLEASE CHOOSE A DIFFERENT OPTION");

            }

        }


    }

    public void FeedMoney() {

        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "Please insert cash amount >>> ");

        String value = input.nextLine();
        double cash = Double.parseDouble((value));

        if (cash > 0) {
            this.cashBalance = getCashBalance() + cash;
            CreateLog("FEED MONEY:", cash);
            DisplayBalance();
        } else {
            System.out.println("\nInvalid input, please try again.");
        }

    }

    public void SubtractFromBalance(double amount) {

        BigDecimal amountBig = BigDecimal.valueOf(amount);
        BigDecimal balanceBig = BigDecimal.valueOf(cashBalance);
        BigDecimal difference = balanceBig.subtract(amountBig);

        try {
            if (balanceBig.compareTo(amountBig) > 0) {
                balanceBig = difference;
                cashBalance = balanceBig.doubleValue();
                DisplayBalance();
            } else {
                throw new IllegalArgumentException(); //if the cashBalance of the user is less then we use throw to have program say "Insufficient funds"
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nINSUFFICIENT FUNDS: PLEASE INSERT MONEY");
        }
    }

    public void SubtractFromInventory(ProductItem product) {
        product.setNumberOfItems(product.getNumberOfItems() - 1);
    }

    public String DispenseItem(ProductItem item) {
        String dispense = "Dispensing " + item.getName() + "... Great choice!" + "\n" + item.getSoundEffect();
        System.out.println(dispense);
//        System.out.println(item.getSoundEffect());
        return dispense;
    }

    public void FinishTransaction() {

        double startingBalance = getCashBalance();
        BigDecimal balanceBig = BigDecimal.valueOf(startingBalance);
        String finish = "";

        int quarters = 0;
        int nickels = 0;
        int dimes = 0;
        int pennies = 0;
        double total = getCashBalance();

        CreateLog("GIVE CHANGE:", startingBalance);

        while (balanceBig.compareTo(BigDecimal.valueOf(0)) > 0) {

            if (balanceBig.compareTo(BigDecimal.valueOf(.25)) >= 0) {
                balanceBig = balanceBig.subtract(BigDecimal.valueOf(.25));
                quarters++;
            } else if (balanceBig.compareTo(BigDecimal.valueOf(.05)) >= 0) {
                balanceBig = balanceBig.subtract(BigDecimal.valueOf(.10));
                dimes++;
            } else if (balanceBig.compareTo(BigDecimal.valueOf(.05)) >= 0) {
                balanceBig = balanceBig.subtract(BigDecimal.valueOf(.05));
                nickels++;
            } else {
                balanceBig = balanceBig.subtract(BigDecimal.valueOf(.01));
                pennies++;
            }

        }

        finish = "Your change is $" + String.format("%.2f", startingBalance) + "." + " That comes out to " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + pennies + " pennies.";
        System.out.println("\n" + finish);
        setCashBalance(0);
        DisplayBalance();
    }

    public void ExitMessage() {
        System.out.println("\nHave a nice day!");
    }

    public class SoldOut extends Exception {

        public SoldOut (String errorMessage) {
            super (errorMessage);
        }

        public SoldOut() {}

    }

    public void CreateLog(String operation, double money) {

        File logFile = new File("Log.txt");
        SimpleDateFormat dateTime = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        String dateTimeString = dateTime.format(new Date());

        if (operation.equals("FEED MONEY:")) {
            totalMoney += money;
        } else {
            totalMoney -= money;
        }

        String logLine = dateTimeString + " " + operation + " $" + String.format("%.2f", money) + " $" + String.format("%.2f", totalMoney);

        try (Writer log = new FileWriter(logFile, true)) {

            log.append(logLine + "\n");

        } catch (Exception e) {
            System.out.println("There was an error");
        }

    }


    public void SalesReport() {

        double totalSales = 0;
        int startingInventory = 5;

        System.out.printf("\n%-20s %-10s\n\n", "Item", "Quantity");

        for (ProductItem actualProduct : products) {
            int remainingQuantity = actualProduct.getRemainingQuantity();
            if (remainingQuantity < actualProduct.getInitialQuantity()) {
                System.out.printf("%-20s %-10d\n", actualProduct.getName(), ((remainingQuantity - actualProduct.getInitialQuantity()) + startingInventory));
                totalSales = (actualProduct.getInitialQuantity() - remainingQuantity) * actualProduct.getPrice();

            }
        }
        System.out.println("\n**TOTAL SALES** $" + String.format("%.2f", totalSales));

    }

    public List <String> CreateListOfCodes() {

        for (ProductItem product : products) {

            listOfCodes.add(product.getCode());

        }

        return listOfCodes;

    }
}

