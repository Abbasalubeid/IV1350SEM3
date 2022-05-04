package se.kth.iv1350.POS.model;

/**
 * Represents a printer that can print out a receipt
 * 
 * @author abbas
 *
 */
public class Printer {

	/**
	 * Prints out the given receipt to the console for testing this program, it should
	 * print the same output to an paper in real world.
	 * 
	 * @param receipt is the receipt object that contains the information that
	 *                should be printed
	 */
	public void printReceipt(Receipt receiptToPrint) {
		System.out.println(receiptToPrint.toString());

	}

}
