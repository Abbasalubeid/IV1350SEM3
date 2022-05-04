/**
 * 
 */
package se.kth.iv1350.POS.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author abbas
 *
 */
class IdentifierTest {
	private Identifier identifier;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		identifier = new Identifier("abc");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		identifier = null;
	}

	/**
	 * Tests if an instance of identifier is equal to null
	 */
	@Test
	void testIdentifierIsNotEqualToNull() {
		assertFalse(identifier.equals(null), "The identifier is equal to Null");
	}

	/**
	 * Tests if an instance of identifier is equal to itself
	 */
	@Test
	void testIdentifierIsEqualToItself() {
		assertTrue(identifier.equals(identifier), "The identifier is not equal to itself");
	}

	/**
	 * Tests if an instance of identifier is equal to an object of another type
	 */
	@Test
	void testIdentifierIsNotEqualToOtherType() {
		assertFalse(identifier.equals(new Object()), "The identifier is equal to an object of antoher type");
	}

	/**
	 * Tests if an instance of identifier is equal to other identifier object
	 */
	@Test
	void testIdentifierIsNotEqualToOtherHolder() {
		assertFalse(identifier.equals(new Identifier("def")),
				"The identifier was equal to another identifier that has another barcode");
	}

}
