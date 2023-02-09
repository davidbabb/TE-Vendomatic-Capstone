package com.techelevator;

import com.techelevator.view.VendingMenu;

import java.io.File;
import java.text.FieldPosition;
import java.util.Scanner;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_SECRET_OPTION = "*Sales Report";

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_SECRET_OPTION };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean running = true;
		String pathOfFile = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv";
		File readingFile = new File(pathOfFile);
		User user = new User();
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			// A switch statement could also be used here.  Your choice.
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				menu.DisplayMenu();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				user.DisplayBalance();

				while (running) {

					String inputChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (inputChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						user.DisplayBalance();
						user.FeedMoney();

					} else if (inputChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

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

}
