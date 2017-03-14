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
	
	@Test
	public void TestMakeChange() {
		assertEquals("1 1 3", machine1.makeChange(90));
		machine1.addCoins(0, 0, 10);
		assertEquals("0 0 8", machine1.makeChange(200));
	}
	
	@Test
	public void TestSoldOut() {
		for (int i = 0; i < 20; i++){
			machine1.addCoins(0, 0, 4);
			machine1.buyItem("cola");
		}
		assertEquals(0, machine1.getInventory("cola"));
		assertFalse(machine1.buyItem("cola"));
	}

	@Test
	public void TestExactChangeOnly() {
		machine1.makeChange(300);
		assertTrue(machine1.getExactChange());
	}

}
