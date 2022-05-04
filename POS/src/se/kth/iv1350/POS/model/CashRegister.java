package se.kth.iv1350.POS.model;

/**
 * Represents the cash register that contains the cash that cashier can access
 * 
 * @author abbas
 *
 */
public class CashRegister {
	private double amount;

	public CashRegister() {
		this.amount = 0;
	}

	/**
	 * 
	 * @return The amount of this cash register
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Increases the amount to a new amount.
	 * 
	 * @param newAmount the new amount to set.
	 */
	public void increaseAmount(double newAmount) {
		amount += newAmount;
	}

}
