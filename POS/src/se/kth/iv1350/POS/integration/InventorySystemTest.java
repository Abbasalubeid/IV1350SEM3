/**
 * 
 */
package se.kth.iv1350.POS.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.POS.model.Identifier;

/**
 * @author abbas
 *
 */
class InventorySystemTest {
	private InventorySystem inventorySystem = new InventorySystem();

	@Test
	void getItemDTOByIdentifierTest() {
		ItemDTO tomatoItemDTO = new ItemDTO("Tomato", 4.90, 0.12);
		Identifier identifier = new Identifier("t1020k");
		assertEquals(inventorySystem.getItemDTO(identifier), tomatoItemDTO, "The identifier is not providing item");

	}

}
