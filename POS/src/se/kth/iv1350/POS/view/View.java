package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.ItemDTO;

/**
 * This is a placehodlder for the real view. It contains a hardcoded execution
 * with calls to all system operations in the controller
 * 
 * @author abbas
 *
 */

public class View {
	private Controller contr;
	private double totalPrice;
	private double change;

	/**
	 * 
	 * Creates a new instance, that uses the specified controller for all calls to
	 * other layers.
	 * 
	 * @param contr The controller to use for all calls to other layers.
	 */
	public View(Controller contr) {
		this.contr = contr;

	}

	public void runFakeExecution() {
		String barcodeForTomato = "t1020k";
		String barcodeForChips = "c1020k";
		String barcodeForKetchup = "k1020k";
		
		contr.startSale();
		System.out.println("A new sale has been started" + "\n");
		contr.scanItem(barcodeForTomato);
		contr.scanItem(barcodeForTomato);
		contr.scanItem(barcodeForChips);
		contr.scanItem(barcodeForKetchup);
		System.out.println("Items has been scanned" + "\n");
		contr.IncreaseQuantityOfLastAddedItem(3);
		System.out.println("The last scanned item (Ketchup in this case) has been increased in quantity" + "\n");
		totalPrice = contr.getTotalPrice();
		System.out.println("The price is: " + totalPrice + "\n");
		change = contr.payment(100);
		System.out.println("The change of this sale is: " + change + "\n");
		contr.endSale();
		System.out.println("The sale is ended and a receipt is printed");

	}

}
