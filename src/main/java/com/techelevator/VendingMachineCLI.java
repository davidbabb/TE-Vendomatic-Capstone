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
		int lineCount = countLines(readingFile);
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


			// A switch statement could also be used here.  Your choice.
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				try (Scanner fileScanner = new Scanner(readingFile)){
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



			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();



	}

	static public int countLines(File newFile) {
		int count = 0;
		try (Scanner masterFile = new Scanner(newFile)) {
			while (masterFile.hasNextLine()) {

				masterFile.nextLine();
				count++;

			}
		} catch (Exception e) {
			System.out.println("error occurred");
		}
		return count;

	}
//	static public String getConvertedFile(File inputFile, int lineNumber) {
//
//		String inputPath = inputFile.getAbsolutePath();
//
//		int barIndex = inputPath.lastIndexOf("\\");
//		String convertedPath = inputPath.substring(barIndex + 1, periodIndex) + "-" + lineNumber + inputPath.substring(periodIndex);
//
//		return convertedPath;
//
//	}

}
