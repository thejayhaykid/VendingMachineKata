import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	VendingMachine machine1;
	
	@Before
	public void setup() {
		machine1 = new VendingMachine();
	}
	
	@Test
	public void TestInitializer() {
		assertEquals(10, machine1.getNumNickels());
		assertEquals(10, machine1.getNumDimes());
		assertEquals(10, machine1.getNumQuarters());
		assertEquals(20, machine1.getInventory("cola"));
		assertEquals(20, machine1.getInventory("chips"));
		assertEquals(20, machine1.getInventory("candy"));
	}
	
	@Test
	public void TestAddInventory() {
		//TODO: Setup test
		assertEquals(20, machine1.getInventory("cola"));
		boolean tester = machine1.addInventory("cola", 5);
		assertTrue(tester);
		assertEquals(25, machine1.getInventory("cola"));
	}

	@Test
	public void TestAcceptCoins() {
		machine1.addCoins(0, 2, 2);
		assertEquals(10, machine1.getNumNickels());
		assertEquals(12, machine1.getNumDimes());
		assertEquals(12, machine1.getNumQuarters());
	}
}
