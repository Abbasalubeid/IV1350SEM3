package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.Sale;

/**
 * Represents the accounting system that holds information about a specific
 * sale.
 * 
 * @author abbas
 *
 */
public class AccountingSystem {
	private Sale sale;

	public AccountingSystem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Sets the info of the given sale to this accounting system
	 * 
	 * @param sale The sale that contains certain information that needs to be
	 *             replace the old information of this accounting system
	 */
	public void setSale(Sale sale) {
		this.sale = sale;

	}

	/**
	 * @return the sale
	 */
	public Sale getSale() {
		return sale;
	}

}
