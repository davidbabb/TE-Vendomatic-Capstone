package com.techelevator;

import com.techelevator.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class VendingMenu {

	private PrintWriter out;
	private Scanner in;
	private List<ProductItems> actualProducts = new ArrayList<>();
	private double cashBalance;
	private double totalMoney;

	public VendingMenu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***");
		}
		return choice;
	}

	public void DisplayBalance(){
		System.out.println("\n" + "Your total balance is " + "$" + CurrencyFormat(getCashBalance()));
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public void CreateList() {

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
					Chips chips = new Chips(code, product, doublePrice, type);
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
	}

		public void DisplayMenu() {

			System.out.printf("\n%-5s %-20s %-10s %-5s \n\n", "ID", "Product", "Price", "Quantity");

			for (ProductItems actualProduct : actualProducts) {

				System.out.printf("%-5s %-20s %-10s %-5s \n", actualProduct.getCode(), actualProduct.getName(), ("$" + CurrencyFormat(actualProduct.getPrice())), actualProduct.getNumberOfItems());

			}

		}



	public void SelectProduct() throws SoldOut{

		DisplayMenu();
		Scanner input = new Scanner(System.in); //initializes a scanner to take in user input of item code
		System.out.println("\nEnter product code: "); // asks user for item code
		String productCode = input.nextLine().toUpperCase(); //forces all input to Upper casing matching the .csv file
		double itemPrice = 0.00;
		double currentBalance = 0.00;

		for (int i = 0; i < actualProducts.size(); i++) {

			try {

				if (productCode.equals(actualProducts.get(i).getCode())) {

					if (actualProducts.get(i).getNumberOfItems() > 0) {

						itemPrice = actualProducts.get(i).getPrice();
						currentBalance = getCashBalance();
						SubtractFromBalance(itemPrice);

						if (itemPrice < currentBalance) {

							System.out.println("Dispensing " + actualProducts.get(i).getName() + "... Great choice!" );
							System.out.println(actualProducts.get(i).getSoundEffect());
							actualProducts.get(i).setNumberOfItems(actualProducts.get(i).getNumberOfItems() - 1);
							CreateLog(actualProducts.get(i).getName() + " " + actualProducts.get(i).getCode(), actualProducts.get(i).getPrice());

						}

					} else {

						throw new SoldOut();

					}

				} else if (i == actualProducts.size() - 1 && itemPrice == 0) {

					System.out.println("\nINVALID PRODUCT CODE. PLEASE TRY AGAIN.");

				}

			} catch (SoldOut e) {

				System.out.println("ITEM IS SOLD OUT, PLEASE CHOOSE A DIFFERENT OPTION");

			}

		}


//			if (selectedSnack == null) { //if selected snack is null then provide invalid message
//				System.out.println("Invalid product code. Please try again.");
//			} else if (selectedSnack.getCount() == 0) { //if selectedSnack count is equal to 0 then provide sold out message
//				System.out.println("Selected snack is sold out. Please select another product.");
//			} else {
//				if (user.getCashBalance() >= selectedSnack.getPrice()) { //checks if they user's cash balance is greater or equal to the price of the selected snack price
//					user.SubtractFromBalance(selectedSnack.getPrice());
//					{ //calls the method subtractFromBalance method on the user object and subtracts the price of the selectedSnack
//						selectedSnack.reduceItemQuantityByOne();// calls the reduceItemQuantityByOne method (in ProductCount) on selectedSnack object and it will decrease by 1
//						System.out.println("You have successfully purchased" + selectedSnack.getName()); //print out the String and name of product as confirmation
//						System.out.println("Your balance is now $" + user.getCashBalance()); //prints out the string and the new balance
//					}
//				} else {
//					System.out.println("Insufficient balance. Please add more money."); //prints out String if the users cash balance is less the the price of the selected snack.
//				}
//			}

		}

	public void FeedMoney() {

		Scanner input = new Scanner(System.in);
		System.out.println("\n" + "Please insert cash amount >>> ");

		String value = input.nextLine();
		double cash = Double.parseDouble((value));

		this.cashBalance = getCashBalance() + cash;
		CreateLog("FEED MONEY:", cash);
		DisplayBalance();

	}

	public void SubtractFromBalance(double amount) {

		try {
			if (cashBalance >= amount) { // checks to see if the amount given by the user "cashBalance" is greater than amount we are looking to subtract from the cost of an item.
				cashBalance -= amount;//if it is then we subtract the amount and then the new cashBalance given
				DisplayBalance();
			} else {
				throw new IllegalArgumentException(); //if the cashBalance of the user is less then we use throw to have program say "Insufficient funds"
			}
		} catch (IllegalArgumentException e) {
			System.out.println("\nINSUFFICIENT FUNDS: PLEASE INSERT MONEY");
		}
	}

	public void FinishTransaction() {

		double startingBalance = getCashBalance();
		String finish = "";

		int quarters = 0;
		int nickels = 0;
		int dimes = 0;
		int pennies = 0;
		double total = getCashBalance();

		CreateLog("GIVE CHANGE:", startingBalance);

		while (total >= .01) {

			if (total >= .25) {
				total -= .25;
				quarters++;
			} else if (total >= .10) {
				total -= .10;
				dimes++;
			} else if (total >= .05) {
				total -= .05;
				nickels++;
			} else {
				total -= .01;
				pennies++;
			}

		}

		finish = "Your change is $" + CurrencyFormat(startingBalance) + "." + " That comes out to " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + pennies + " pennies.";
		System.out.println("\n" + finish);
		setCashBalance(0);
		DisplayBalance();
	}

	public String CurrencyFormat(double number) {

		String updatedNumber = Double.toString(number);

		int periodIndex = updatedNumber.indexOf(".");
		int numberLength = updatedNumber.length();
		int periodLength = updatedNumber.substring(periodIndex, numberLength).length();

		if (periodLength == 3) {

			return updatedNumber;

		} else if (periodLength < 3) {

			updatedNumber += "0";

		} else {

			updatedNumber = updatedNumber.substring(0, periodIndex + 3);

		}

		return updatedNumber;

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

		String logLine = dateTimeString + " " + operation + " $" + CurrencyFormat(money) + " $" + CurrencyFormat(totalMoney);

		try (Writer log = new FileWriter(logFile, true)) {

			log.append(logLine + "\n");

		} catch (Exception e) {
			System.out.println("There was an error");
		}

	}


}
