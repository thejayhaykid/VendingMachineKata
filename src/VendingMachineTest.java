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
		assertEquals(10, machine1.getNumNickles());
		assertEquals(10, machine1.getNumDimes());
		assertEquals(10, machine1.getNumQuarters());
	}
	
	@Test
	public void TestAddInventory() {
		//TODO: Setup test
	}

}
