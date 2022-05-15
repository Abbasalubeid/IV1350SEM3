package se.kth.iv1350.POS.model;

import java.util.HashMap;

import se.kth.iv1350.POS.integration.ItemDTO;

/**
 * Represents one single sale, contains all information about the sale.
 * 
 * @author abbas
 *
 */
public class Sale {
	private double totalPrice = 0;
	private double paidAmount = 0;
	private double change = 0;
	private double totalVAT = 0;
	private ItemDTO recentAddedItem;
	private HashMap<ItemDTO, Integer> listOfItems = new HashMap<>();
	private Receipt receipt;

	/**
	 * Creates a new instance of a sale
	 */
	public Sale() {
		receipt = new Receipt();

	}

	/**
	 * 
	 * @return The paid amount of this sale.
	 */
	public double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @return The list of items in this sale.
	 */
	public HashMap<ItemDTO, Integer> getListOfItems() {
		return listOfItems;
	}

	/**
	 * Sets the paid amount to a certain number so that it can get sent to receipt
	 * correctly.
	 * 
	 * @param paidAmount The amount paid by the customer
	 */
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return the current amount of the total price in this sale.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price to a specific amount.
	 * 
	 * @param totalPrice The amount that the total priced is initialized to.
	 */
	private void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the current amount of change in this sale.
	 */
	public double getChange() {
		return totalPrice;
	}

	/**
	 * Sets the amount of change to a specific amount
	 * 
	 * @param change The specific amount to set
	 */
	private void setChange(double change) {
		this.change = change;
	}

	/**
	 * @return The total tax of this sale
	 */
	public double getTotalVAT() {
		return totalVAT;
	}

	/**
	 * Sets the total tax to a specific amount.
	 * 
	 * @param totalTax The totalTax to set
	 */
	private void setTotalVAT(double totalVAT) {
		this.totalVAT = totalVAT;
	}



	/**
	 * Adds a certain item to the list of items in this sale, the price of this item
	 * gets added to the running total and the same item is also saved as an
	 * variable for later usage, however if the item is already added earlier in
	 * this this sale then we only increase the quantity, total price and save the
	 * item for later usage The total VAT amount is also increased with a specific
	 * items VAT amount every time an item is added.
	 * 
	 * @param itemToAdd The item that is added to the list
	 */
	public void addItem(ItemDTO itemToAdd) {
		if (getListOfItems().containsKey(itemToAdd)) {
			addItemQuantity(listOfItems.get(itemToAdd) + 1);
			recentAddedItem = itemToAdd;
			increaseTotalPrice(itemToAdd, 1);
			setTotalVAT(getTotalVAT() + getVAT(itemToAdd));
		} else {
			getListOfItems().put(itemToAdd, 1);
			recentAddedItem = itemToAdd;
			increaseTotalPrice(itemToAdd, 1);
			setTotalVAT(getTotalVAT() + getVAT(itemToAdd));
		}

	}

	/**
	 * Adds the recent added item to the sale several times. The item is saved
	 * earlier when/if it was added earlier in this sale.
	 * 
	 * @param quantityOfTheItem The amount of times to add the same item to the sale
	 */
	public void addItemQuantity(Integer quantityOfTheItem) {
		getListOfItems().put(recentAddedItem, quantityOfTheItem);

	}

	/**
	 * Increases to total price by the price of a specific item and a specific
	 * quantity
	 * 
	 * @param itemToAddThePriceOf The specific item
	 * @param itemQuantity        The quantity of the specific item
	 */
	private void increaseTotalPrice(ItemDTO itemToAddThePriceOf, int itemQuantity) {
		setTotalPrice(
				getTotalPrice() + ((itemToAddThePriceOf.getPrice() + getVAT(itemToAddThePriceOf)) * itemQuantity));

	}

	/**
	 * Calculates the VAT of a specific item based on the tax rate.
	 * 
	 * @param itemToCalculateVATOf The specific item.
	 * @return The VAT amount of this item.
	 */
	private double getVAT(ItemDTO itemToCalculateVATOf) {
		return itemToCalculateVATOf.getTaxRate() * itemToCalculateVATOf.getPrice();

	}

	/**
	 * Calculates the amount of change based on the paid amount and the total price
	 * of this sale
	 * 
	 * @return The amount of change
	 */
	public double calculateChange() {
		setChange(paidAmount - totalPrice);
		return change;
	}

	/**
	 * Updates a receipt with information about this sale
	 */
	public void updateReceipt() {
		receipt.setSaleInfo(this);
	}

	/**
	 * @return The receipt of this sale.
	 */
	public Receipt getReceipt() {
		return receipt;
	}

	/**
	 * Makes a string representation of this sale
	 *
	 * @return The string representation of this sale
	 */
	@Override
	public String toString() {
		StringBuilder saleSB = new StringBuilder();



		var itemSet = getListOfItems().entrySet();
		for (var entry : itemSet) {
			saleSB.append("Item: ");
			saleSB.append(entry.getKey().getItemDescription());
			saleSB.append(" Quantity: ");
			saleSB.append(entry.getValue());
			appendNewLine(saleSB);
		}

		saleSB.append("Total price of the sale ");
		saleSB.append(totalPrice);
		appendNewLine(saleSB);

		saleSB.append("Total amount of VAT: ");
		saleSB.append(totalVAT);
		appendNewLine(saleSB);

		saleSB.append("Total amount paid: ");
		saleSB.append(paidAmount);
		appendNewLine(saleSB);

		saleSB.append("Total amount of change: ");
		saleSB.append(change);
		appendNewLine(saleSB);

		return saleSB.toString();

	}

	private void appendNewLine(StringBuilder StringBuilderToAppendNewLineOn) {
		StringBuilderToAppendNewLineOn.append("\n");

	}

}
