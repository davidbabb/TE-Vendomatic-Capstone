package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.io.File;
import java.text.FieldPosition;
import java.util.Locale;
import java.util.Scanner;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean running = true;
//		String pathOfFile = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv";
//		File readingFile = new File(pathOfFile);
		User user = new User();
		menu.CreateList();
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			// A switch statement could also be used here.  Your choice.
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				menu.DisplayMenu();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				menu.DisplayBalance();

				while (running) {

					String inputChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (inputChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						menu.DisplayBalance();
						menu.FeedMoney();

					} else if (inputChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

						menu.SelectProduct();

//						menu.DisplayMenu(); //Displays all the items
//						Scanner input = new Scanner(System.in); //initializes a scanner to take in user input of item code
//						System.out.println("Enter product code: "); // asks user for item code
//						String productCode = input.nextLine().toUpperCase(); //forces all input to Upper casing matching the .csv file
//						ProductCount selectedSnack = ProductCount.getSnackByItemCode(productCode); //calls method getSnackByItemCode from the ProductCount class and passing the value of the productCode. This will give us an instance of ProductCount class that will correspond to the productCode and it will be stored into selectedSnack
//						if (selectedSnack == null){ //if selected snack is null then provide invalid message
//							System.out.println("Invalid product code. Please try again.");
//						}
//						else if (selectedSnack.getCount() == 0){ //if selectedSnack count is equal to 0 then provide sold out message
//							System.out.println("Selected snack is sold out. Please select another product.");
//						}
//						else{
//							if (user.getCashBalance() >= selectedSnack.getPrice()){ //checks if they user's cash balance is greater or equal to the price of the selected snack price
//								user.SubtractFromBalance(selectedSnack.getPrice()); { //calls the method subtractFromBalance method on the user object and subtracts the price of the selectedSnack
//									selectedSnack.reduceItemQuantityByOne();// calls the reduceItemQuantityByOne method (in ProductCount) on selectedSnack object and it will decrease by 1
//									System.out.println("You have successfully purchased" + selectedSnack.getName()); //print out the String and name of product as confirmation
//									System.out.println("Your balance is now $" + user.getCashBalance()); //prints out the string and the new balance
//								}
//							} else {
//								System.out.println("Insufficient balance. Please add more money."); //prints out String if the users cash balance is less the the price of the selected snack.
//							}
//						}


					}

				}
			}
		}
	}

	public static void main(String[] args) {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}
}
//	static public int countLines(File newFile) {
//		int count = 0;
//		try (Scanner masterFile = new Scanner(newFile)) {
//			while (masterFile.hasNextLine()) {
//
//				masterFile.nextLine();
//				count++;
//
//			}
//		} catch (Exception e) {
//			System.out.println("error occurred");
//		}
//		return count;
//
//	}

//}
