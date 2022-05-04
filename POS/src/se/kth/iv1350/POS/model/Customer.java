package se.kth.iv1350.POS.model;

/**
 * This class represents a customer with a unique customerID
 * 
 * @author abbas
 *
 */
public class Customer {
	private String customerID;

	/**
	 * This is a constructor that creates an instance of the class Customer.
	 * 
	 * @param customerID is a unique String object that every customer has so that
	 *                   they can get identified.
	 */
	public Customer(String customerID) {
		this.customerID = customerID;
	}

}
