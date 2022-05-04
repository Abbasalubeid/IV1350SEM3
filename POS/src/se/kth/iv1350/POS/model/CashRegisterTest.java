/**
 * 
 */
package se.kth.iv1350.POS.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author abbas
 *
 */
class CashRegisterTest {
	private CashRegister instanceOfCR;

	/**
	 * Checks if the method "increaseAmount" increases the amount to the correct
	 * number
	 */
	@Test
	void increaseAmountTest() {
		instanceOfCR = new CashRegister();
		instanceOfCR.increaseAmount(20);
		instanceOfCR.increaseAmount(15);
		assertEquals(35, instanceOfCR.getAmount(), "The amount is not changed to the correct number");

	}

}
