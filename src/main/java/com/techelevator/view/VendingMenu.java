package com.techelevator.view;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMenu {

	private PrintWriter out;
	private Scanner in;
	private Map<String, String> codesAndPrices = new HashMap<>();
	String pathOfFile = "C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv";
	File readingFile = new File(pathOfFile);

	public VendingMenu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
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

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public void DisplayMenu(){

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
	}

	public void CreateMap() {
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
				codesAndPrices.put(code, price);

			}
		}catch (Exception e){
			System.out.println("Error");
		}
	}

}
