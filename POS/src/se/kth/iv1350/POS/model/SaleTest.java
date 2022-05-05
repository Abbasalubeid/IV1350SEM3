/**
 * 
 */
package se.kth.iv1350.POS.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.POS.integration.ItemDTO;

/**
 * @author abbas
 *
 */
class SaleTest {
	private Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		sale = new Sale();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		sale = null;
	}

	/**
	 * Checks if an items price is added correctly to the total price of the sale
	 */
	@Test
	void priceWhenAnItemIsAddedTest() {
		ItemDTO item1 = new ItemDTO("Tomato", 5, 0.25);
		sale.addItem(item1);
		assertEquals(6.25, sale.getTotalPrice(), "The total price is not updated correctly");
	}

	/**
	 * Checks if an items VAT is added correctly to the total VAT of the sale
	 */
	@Test
	void VATWhenAnItemIsAddedTest() {
		ItemDTO item1 = new ItemDTO("Tomato", 5, 0.25);
		sale.addItem(item1);
		assertEquals(1.25, sale.getTotalVAT(), "The total vat is not updated correctly");
	}

	/**
	 * Checks if an item object is added correctly
	 */
	@Test
	void itemIsAddedTest() {
		ItemDTO item1 = new ItemDTO("Tomato", 5, 0.25);
		sale.addItem(item1);
		assertTrue(sale.getListOfItems().containsKey(item1), "The item has not been added to the list correctly");
	}

	/**
	 * Checks that quantity increase when item that already exist gets added again.
	 * 
	 */
	@Test
	void addAnItemThatAlreadyExist() {
		ItemDTO item1 = new ItemDTO("Tomato", 5, 0.25);
		sale.addItem(item1);
		sale.addItem(item1);
		assertEquals(2, sale.getListOfItems().get(item1), "The item quantity has not been added to the list correctly");
	}

	/**
	 * Tests if the change of a sale is calculated correctly
	 */
	@Test
	void calculateChangeTest() {
		ItemDTO item1 = new ItemDTO("Tomato", 5, 0.25);
		ItemDTO item2 = new ItemDTO("chips", 15, 0.25);
		ItemDTO item3 = new ItemDTO("Ketchup", 20, 0.25);
		sale.addItem(item1);
		sale.addItem(item2);
		sale.addItem(item3);
		sale.setPaidAmount(55);
		assertEquals(5, sale.calculateChange(), "The change is not calculated correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of an item in the
	 * sale
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
		assertEquals(true, sale.toString().contains("Tomato"), "The item is not converted to string correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of the total
	 * price in the sale
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
		assertEquals(true, sale.toString().contains("61.95"),
				"The total price amount not converted to string correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of the total VAT
	 * in the sale
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
		sale.setPaidAmount(42);
		sale.calculateChange();
		assertEquals(true, sale.toString().contains("16.95"), "The VAT amount is not converted to string correctly");
	}

	/**
	 * Tests if the toString method makes a correct representation of the change in
	 * the sale
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
		assertEquals(true, sale.toString().contains("19.95"), "The change amount is not converted to string correctly");
	}

}
