package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.AccountingSystem;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.model.CashRegister;
import se.kth.iv1350.POS.model.Identifier;
import se.kth.iv1350.POS.model.Printer;
import se.kth.iv1350.POS.model.Sale;

/**
 * This the application's only controller. All calls to the model pass through
 * this class.
 * 
 * @author abbas
 *
 */

public class Controller {
	private Sale sale;
	private CashRegister cashRegister;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private Printer printer;

	/**
	 * Creates an instance of the controller
	 * 
	 * @param inventorySystem  The inventorySystem that holds information about
	 *                         certain items.
	 * @param accountingSystem The accounting system that holds information about
	 *                         all the sales.
	 * @param printer          The printer that has access to a receipt and can
	 *                         print it.
	 */
	public Controller(InventorySystem inventorySystem, AccountingSystem accountingSystem, Printer printer) {
		this.inventorySystem = inventorySystem;
		this.accountingSystem = accountingSystem;
		this.printer = printer;

	}

	/**
	 * Starts a new sale. This method must be called before doing anything else
	 * during a sale.
	 */
	public void startSale() {
		sale = new Sale();
		cashRegister = new CashRegister();
	}

	/**
	 * @return the inventorySystem
	 */
	public InventorySystem getInventorySystem() {
		return inventorySystem;
	}

	/**
	 * @return the accountingSystem
	 */
	public AccountingSystem getAccountingSystem() {
		return accountingSystem;
	}

	/**
	 * @return the sale
	 */
	public Sale getSale() {
		return sale;
	}

	/**
	 * 
	 * @return The cashRegister
	 */
	public CashRegister getCashRegister() {
		return cashRegister;
	}

	/**
	 * Adds a specific item in the sale.
	 * 
	 * @param barcode A unique code that identifies a certain item.
	 */
	public void scanItem(String barcode) {
		Identifier identifier = new Identifier(barcode);
		sale.addItem(inventorySystem.getItemDTO(identifier));
	}

	/**
	 * Increases the quantity of the last added item in the sale.
	 * 
	 * @param quantity The amount to increase with.
	 */
	public void IncreaseQuantityOfLastAddedItem(int quantity) {
		sale.addItemQuantity(quantity);
	}

	/**
	 * This method is called when the all items in the sale has been added.
	 * 
	 * @return The total price to pay.
	 */
	public double getTotalPrice() {
		return sale.getTotalPrice();
	}

	/**
	 * Represents a payment from the customer, this method updates the cash register
	 * and the sale with the paid amount, the method also returns the calculated
	 * change.
	 * 
	 * @param paidAmount The amount that the customer paid.
	 * @return The change that the customer is getting back.
	 */
	public double payment(double paidAmount) {
		cashRegister.increaseAmount(paidAmount);
		sale.setPaidAmount(paidAmount);
		return sale.calculateChange();
	}

	public void endSale() {
		inventorySystem.setSale(sale);
		accountingSystem.setSale(sale);
		sale.updateReceipt();
		printer.printReceipt(sale.getReceipt());
	}

}
