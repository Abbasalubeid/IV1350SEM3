package se.kth.iv1350.POS.model;

/**
 * Represents one receipt, which proves the payment of one sale.
 * 
 * @author abbas
 *
 */

public class Receipt {
	private Sale sale;

	/**
	 * Sets the sale of this receipt to a given sale.
	 * 
	 * @param sale The given sale.
	 */
	void setSaleInfo(Sale sale) {
		this.sale = sale;
	}

	/**
	 * Creates a string representation of this receipt.
	 * 
	 * @return The string representation of this receipt.
	 */
	@Override
	public String toString() {
		StringBuilder receiptBuilder = new StringBuilder();
		receiptBuilder.append("RECEIPT");
		receiptBuilder.append("\n");
		receiptBuilder.append(sale.toString());
		return receiptBuilder.toString();

	}

}
