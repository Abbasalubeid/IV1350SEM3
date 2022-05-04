package se.kth.iv1350.POS.startup;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.POS.view.View;

class mainTest {

	private Main instanceToTest;
	private ByteArrayOutputStream printoutBuffer;
	private PrintStream originalSysOut;
	
	
	@BeforeEach
	void setUp() throws Exception {
		instanceToTest = new Main(); 
		
		printoutBuffer = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream(printoutBuffer);
		originalSysOut = System.out;
		System.setOut(inMemSysOut);
	}

	@AfterEach
	void tearDown() throws Exception {
		instanceToTest = null;
		printoutBuffer = null;
		System.setOut(originalSysOut);
	}

	@Test
	public void testThatUIHasStarted() {
		String[] args = null;
		Main.main(args);
		String printout = printoutBuffer.toString();
		String expectedOutput = "started";
		assertTrue(printout.contains(expectedOutput), "UI did not start correctly");
	}

}
