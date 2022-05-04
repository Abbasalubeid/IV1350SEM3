package se.kth.iv1350.POS.model;

import java.util.Objects;

/**
 * This class represents an identifier for an item.
 * 
 * @author abbas
 *
 */
public class Identifier {
	private String barcode;

	/**
	 * This constructor creates an identifier that holds the specific barcode of an
	 * item
	 * 
	 * @param barcode is the unique code that every item has to get identified
	 */
	public Identifier(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Identifier)) {
			return false;
		}
		Identifier other = (Identifier) obj;
		if (barcode == null) {
			if (other.barcode != null) {
				return false;
			}
		} else if (!barcode.equals(other.barcode)) {
			return false;
		}
		return true;
	}

}
