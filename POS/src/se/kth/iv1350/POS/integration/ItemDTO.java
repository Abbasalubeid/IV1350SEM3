package se.kth.iv1350.POS.integration;

/**
 * A data transfer object that contains all data that describes an object.
 * 
 * @author abbas
 *
 */

public class ItemDTO {
	private String itemDescription;
	private double price;
	private double taxRate;

	/**
	 * Constructs a data transfer object that represents a particular item
	 * 
	 * 
	 * @param itemName        The name of that specific item
	 * @param itemDescription A short description of that specific item
	 * @param price           The price of the item
	 * @param taxRate         The percentage of the tax that is included on the
	 *                        price
	 */
	public ItemDTO(String itemDescription, double price, double taxRate) {
		this.itemDescription = itemDescription;
		this.price = price;
		this.taxRate = taxRate;
	}

	/**
	 * @return the Price of this item
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return the taxRate of this item
	 */
	public double getTaxRate() {
		return taxRate;
	}

	/**
	 * @return the itemDescription of this item
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * Generates a hash code for this class
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Checks if two object instances of this class is equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemDTO)) {
			return false;
		}
		ItemDTO other = (ItemDTO) obj;
		if (itemDescription == null) {
			if (other.itemDescription != null) {
				return false;
			}
		} else if (!itemDescription.equals(other.itemDescription)) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (Double.doubleToLongBits(taxRate) != Double.doubleToLongBits(other.taxRate)) {
			return false;
		}
		return true;
	}

}
