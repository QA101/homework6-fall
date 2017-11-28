package tst;
import static org.junit.Assert.*;

import org.junit.*;

import src.IOCalculator;

public class IOCaculatorTest {
	double expected;
	double actual;
	static IOCalculator io;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String[] args = {"./resources/input.txt"};
		io = new IOCalculator(args);
	}

	@Test
	public void CalculateTest() throws Exception {

		expected = 6;
		actual = io.Calculate(2, 4, "+");
		assertTrue("Expected: " + expected + " Actual: "+actual, actual == expected);
		
		
		expected = -2;
		actual = io.Calculate(2, 4, "-");
		assertTrue("Expected: " + expected + " Actual: "+actual, actual == expected);
		
		expected = 8;
		actual = io.Calculate(2, 4, "*");
		assertTrue("Expected: " + expected + " Actual: "+actual, actual == expected);
		
		
		//This test will fail due to a bug. It should be 0.5 ! 0.0
		expected = 0.5;
		actual = io.Calculate(2, 4, "/");
		assertTrue("Expected: " + expected + " Actual: "+actual, actual == expected);
	}
	
	@Test (expected = Exception.class)
	public void CalculateNegativesCases() throws Exception {
		assertTrue(io.Calculate(2, 4, "") == 6);
	}

}
