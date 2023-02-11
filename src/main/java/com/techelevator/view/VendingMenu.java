package com.techelevator.view;

import com.techelevator.*;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class VendingMenu {

	private PrintWriter out;
	private Scanner in;
	private List<ProductItems> actualProducts = new ArrayList<>();
	private double cashBalance;

	String pathOfFile = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv";
	File readingFile = new File(pathOfFile);

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
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	public void DisplayBalance(){
		System.out.println("\n" + "Your total balance: " + "$" + getCashBalance());
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
					Drinks drinks = new Drinks(code, product, doublePrice, type);
					actualProducts.add(drinks);
					i++;
				} else {
					Gum gum = new Gum(code, product, doublePrice, type);
					actualProducts.add(gum);
					i++;
				}
//				ProductItems productItems = new ProductItems(code, product, doublePrice, type);
//				actualProducts.add(fullMenu);
//				System.out.printf("%-5s %-20s %-10s %-5s \n", fullMenu.getCode(), fullMenu.getName(), ("$" + fullMenu.getPrice()), fullMenu.getNumberOfItems());

			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

//	public void UpdateMenu(ProductItems item, int number) {
//
//		try (Scanner fileScanner = new Scanner(readingFile)) {
//			System.out.printf("\n%-5s %-20s %-10s %-5s \n\n", "ID", "Product", "Price", "Quantity");
//
//			int i = 0;
//
//			while (fileScanner.hasNextLine()) {
//
//				String s = fileScanner.nextLine();
//				String[] arr = s.split("\\|");
//				String code = arr[0];
//				String product = arr[1];
//				String price = arr[2];
//				String type = arr[3];
//				double doublePrice = Double.parseDouble(price);
//				if (i < 4) {
//					Chips chips = new Chips(code, product, doublePrice, type);
//					actualProducts.add(chips);
//					System.out.printf("%-5s %-20s %-10s %-5s \n", chips.getCode(), chips.getName(), ("$" + chips.getPrice()), chips.getNumberOfItems());
//					i++;
//				} else if (i < 8) {
//					Candy candy = new Candy(code, product, doublePrice, type);
//					actualProducts.add(candy);
//					System.out.printf("%-5s %-20s %-10s %-5s \n", candy.getCode(), candy.getName(), ("$" + candy.getPrice()), candy.getNumberOfItems());
//					i++;
//				} else if (i < 12) {
//					Drinks drinks = new Drinks(code, product, doublePrice, type);
//					actualProducts.add(drinks);
//					System.out.printf("%-5s %-20s %-10s %-5s \n", drinks.getCode(), drinks.getName(), ("$" + drinks.getPrice()), drinks.getNumberOfItems());
//				} else {
//					Gum gum = new Gum(code, product, doublePrice, type);
//					actualProducts.add(gum);
//					System.out.printf("%-5s %-20s %-10s %-5s \n", gum.getCode(), gum.getName(), ("$" + gum.getPrice()), gum.getNumberOfItems());
//					i++;
//				}
////				ProductItems productItems = new ProductItems(code, product, doublePrice, type);
////				actualProducts.add(fullMenu);
////				System.out.printf("%-5s %-20s %-10s %-5s \n", fullMenu.getCode(), fullMenu.getName(), ("$" + fullMenu.getPrice()), fullMenu.getNumberOfItems());
//
//			}
//		} catch (Exception e) {
//			System.out.println("Error");
//		}
//	}

		public void DisplayMenu() {

		try (Scanner fileScanner = new Scanner(readingFile)) {
			System.out.printf("\n%-5s %-20s %-10s %-5s \n\n", "ID", "Product", "Price", "Quantity");

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
					System.out.printf("%-5s %-20s %-10s %-5s \n", chips.getCode(), chips.getName(), ("$" + chips.getPrice()), chips.getNumberOfItems());
					i++;
				} else if (i < 8) {
					Candy candy = new Candy(code, product, doublePrice, type);
					System.out.printf("%-5s %-20s %-10s %-5s \n", candy.getCode(), candy.getName(), ("$" + candy.getPrice()), candy.getNumberOfItems());
					i++;
				} else if (i < 12) {
					Drinks drinks = new Drinks(code, product, doublePrice, type);
					System.out.printf("%-5s %-20s %-10s %-5s \n", drinks.getCode(), drinks.getName(), ("$" + drinks.getPrice()), drinks.getNumberOfItems());
				} else {
					Gum gum = new Gum(code, product, doublePrice, type);
					System.out.printf("%-5s %-20s %-10s %-5s \n", gum.getCode(), gum.getName(), ("$" + gum.getPrice()), gum.getNumberOfItems());
					i++;
				}
//				ProductItems productItems = new ProductItems(code, product, doublePrice, type);
//				actualProducts.add(fullMenu);
//				System.out.printf("%-5s %-20s %-10s %-5s \n", fullMenu.getCode(), fullMenu.getName(), ("$" + fullMenu.getPrice()), fullMenu.getNumberOfItems());

			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}


	public void SelectProduct() {

		DisplayMenu();
		Scanner input = new Scanner(System.in); //initializes a scanner to take in user input of item code
		System.out.println("Enter product code: "); // asks user for item code
		String productCode = input.nextLine().toUpperCase(); //forces all input to Upper casing matching the .csv file
//		ProductCount selectedSnack = ProductCount.getSnackByItemCode(productCode); //calls method getSnackByItemCode from the ProductCount class and passing the value of the productCode. This will give us an instance of ProductCount class that will correspond to the productCode and it will be stored into selectedSnack
		double itemPrice = 0.00;

		for (int i = 0; i < actualProducts.size(); i++) {

			if (productCode.equals(actualProducts.get(i).getCode())) {

				itemPrice = actualProducts.get(i).getPrice();
				SubtractFromBalance(itemPrice);


				System.out.println(actualProducts.get(i).getSoundEffect());

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
		DisplayBalance();

	}

	public void SubtractFromBalance(double amount){
		if(cashBalance >= amount){ // checks to see if the amount given by the user "cashBalance" is greater than amount we are looking to subtract from the cost of an item.
			cashBalance -= amount;//if it is then we subtract the amount and then the new cashBalance given
			DisplayBalance();
		} else {
			throw new IllegalArgumentException("Insufficient funds"); //if the cashBalance of the user is less then we use throw to have program say "Insufficient funds"
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

		while (total > 0) {

			if (total > .25) {
				total -= .25;
				quarters++;
			} else if (total > .10) {
				total -= .10;
				dimes++;
			} else if (total > .05) {
				total -= .05;
				nickels++;
			} else {
				total -= .01;
				pennies++;
			}

		}

		finish = "Your change is $" + startingBalance + "." + " That comes out to " + quarters + " quarters " + dimes + " dimes " + nickels + " nickels " + pennies + " pennies.";
		System.out.println("\n" + finish);
		setCashBalance(0);
	}


}
