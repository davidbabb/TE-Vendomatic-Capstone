package com.techelevator;


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

	public void run() throws VendingMenu.SoldOut {
		boolean running = true;
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

					} else if (inputChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

						menu.FinishTransaction();
						break;

					}

				}


			}
			else if (choice.equals(MAIN_MENU_SECRET_OPTION)) {

				menu.SalesReport();


			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {

				menu.ExitMessage();
				return;
			}
		}
	}

	public static void main(String[] args) throws VendingMenu.SoldOut {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();


	}
}
