/**
 * 
 */
package se.kth.iv1350.POS.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.POS.integration.ItemDTO;

/**
 * @author abbas
 *
 */
class ReceiptTest {
	private Receipt receipt;
	private Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		sale = new Sale();
		receipt = new Receipt();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		sale = null;
		receipt = null;
	}

	/**
	 * Test the string representation of a receipt with a certain sale
	 */
	@Test
	void reeiptToStringTest() {
		ItemDTO tomato = new ItemDTO("Tomato", 5, 0.12);
		ItemDTO chips = new ItemDTO("chips", 15, 0.25);
		ItemDTO ketchup = new ItemDTO("Ketchup", 20, 0.6);
		sale.addItem(tomato);
		sale.addItem(ketchup);
		sale.addItem(tomato);
		sale.addItem(chips);
		sale.setPaidAmount(42);
		sale.calculateChange();
		receipt.setSaleInfo(sale);
		assertEquals(true, receipt.toString().contains("RECEIPT"), "The receipt word is being added correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of an item in the
	 * receipt
	 */
	@Test
	void saleToStringItemTest() {
		ItemDTO tomato = new ItemDTO("Tomato", 5, 0.12);
		ItemDTO chips = new ItemDTO("chips", 15, 0.25);
		ItemDTO ketchup = new ItemDTO("Ketchup", 20, 0.6);
		sale.addItem(tomato);
		sale.addItem(ketchup);
		sale.addItem(tomato);
		sale.addItem(chips);
		receipt.setSaleInfo(sale);
		assertEquals(true, receipt.toString().contains("Tomato"), "The item is not converted to string correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of the total
	 * price in the receipt
	 */
	@Test
	void saleToStringTotalPriceTest() {
		ItemDTO tomato = new ItemDTO("Tomato", 5, 0.12);
		ItemDTO chips = new ItemDTO("chips", 15, 0.25);
		ItemDTO ketchup = new ItemDTO("Ketchup", 20, 0.6);
		sale.addItem(tomato);
		sale.addItem(ketchup);
		sale.addItem(tomato);
		sale.addItem(chips);
		receipt.setSaleInfo(sale);
		assertEquals(true, receipt.toString().contains("61.95"),
				"The total price amount not converted to string correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of the total VAT
	 * in the receipt
	 */
	@Test
	void saleToStringTotalVATTest() {
		ItemDTO tomato = new ItemDTO("Tomato", 5, 0.12);
		ItemDTO chips = new ItemDTO("chips", 15, 0.25);
		ItemDTO ketchup = new ItemDTO("Ketchup", 20, 0.6);
		sale.addItem(tomato);
		sale.addItem(ketchup);
		sale.addItem(tomato);
		sale.addItem(chips);
		receipt.setSaleInfo(sale);
		assertEquals(true, receipt.toString().contains("16.95"), "The VAT amount is not converted to string correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of the change in
	 * the receipt
	 */
	@Test
	void saleToStringChangeTest() {
		ItemDTO tomato = new ItemDTO("Tomato", 5, 0.12);
		ItemDTO chips = new ItemDTO("chips", 15, 0.25);
		ItemDTO ketchup = new ItemDTO("Ketchup", 20, 0.6);
		sale.addItem(tomato);
		sale.addItem(ketchup);
		sale.addItem(tomato);
		sale.addItem(chips);
		sale.setPaidAmount(42);
		sale.calculateChange();
		receipt.setSaleInfo(sale);
		assertEquals(true, receipt.toString().contains("19.95"),
				"The change amount is not converted to string correctly");
	}

}
