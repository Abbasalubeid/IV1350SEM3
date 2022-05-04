package se.kth.iv1350.POS.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemDTOTest {
	ItemDTO itemDTO;

	@BeforeEach
	void setUp() throws Exception {
		itemDTO = new ItemDTO("Ketchup", 29.90, 0.6);
	}

	@AfterEach
	void tearDown() throws Exception {
		itemDTO = null;
	}

	/**
	 * Tests if an instance of itemDTO is equal to null
	 */
	@Test
	void testIdentifierIsNotEqualToNull() {
		assertFalse(itemDTO.equals(null), "The ItemDTO is equal to Null");
	}

	/**
	 * Tests if an instance of itemDTO is equal to itself
	 */
	@Test
	void testIdentifierIsEqualToItself() {
		assertTrue(itemDTO.equals(itemDTO), "The ItemDTO is not equal to itself");
	}

	/**
	 * Tests if an instance of itemDTO is equal to an object of another type
	 */
	@Test
	void testIdentifierIsNotEqualToOtherType() {
		assertFalse(itemDTO.equals(new Object()), "The ItemDTO is equal to an object of antoher type");
	}

	/**
	 * Tests if an instance of itemDTO is equal to itself
	 */
	@Test
	void testIdentifierIsNotEqualToOtherHolder() {
		assertFalse(itemDTO.equals(new ItemDTO("Burger", 29.90, 0.6)),
				"The ItemDTO was equal to another identifier with other instance variables");
	}

}
