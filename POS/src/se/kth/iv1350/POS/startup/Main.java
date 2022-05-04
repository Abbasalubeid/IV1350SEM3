package se.kth.iv1350.POS.startup;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.AccountingSystem;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.model.Printer;
import se.kth.iv1350.POS.view.View;

/**
 * Starts the entire application, contains the main method used to start the
 * application.
 * 
 * @author abbas
 *
 */

public class Main {
	/**
	 * The main method used to start the application
	 * 
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		Printer printer = new Printer();
		InventorySystem inventorySystem = new InventorySystem();
		AccountingSystem accountingSystem = new AccountingSystem();
		Controller contr = new Controller(inventorySystem, accountingSystem, printer);
		View view = new View(contr);
		view.runFakeExecution();

	}

}
