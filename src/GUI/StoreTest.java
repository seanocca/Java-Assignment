package GUI;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DeliveryException;

/**
 * Tests the class Store
 * @author Sean O'Connell
 *
 */
public class StoreTest {

	//Initialize Store variables
	private String storeName = "Mart";
	private double capital = 1000;
	private Store store;
	
	/**
	 * Setup the Store to be tested in this JUnit
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		store = new Store(storeName, capital);
	}

	/**
	 * Test the creation of the Store 
	 * and if it's variables are consist
	 * 
	 */
	@Test
	public void testStore() {
		Store initStore = store;
		assertEquals(initStore, store);
	}
	
	/**
	 * Test the function that retrieves the Store name
	 * 
	 */
	@Test
	public void testGetStoreName() {
		assertEquals(storeName, store.GetStoreName());
	}

	/**
	 * Test the function that retrieves the Store capital
	 * 
	 */
	@Test
	public void testGetStoreCapital() {
		assertEquals(store.GetStoreCapital(), capital, 0.01);
	}

	/**
	 * Test the function that retrieves the Store capital
	 * and that it returns as a 
	 * 
	 */
	@Test
	public void testGetCapitalString() {
		String output = "Store Capital: $" + NumberFormat.getNumberInstance(Locale.US).format(capital);
		assertEquals(store.GetCapitalString(), output);
	}

	/**
	 * Test the function that negatively adjusts the capital
	 * As if the store is paying for a shipment
	 * @throws DeliveryException
	 * 
	 */
	@Test
	public void testPayWithCapital() throws DeliveryException {
		store.PayWithCapital(100);
	}

	/**
	 * Test the function that positively adjusts the store capital
	 * As if the store has made money from the inventory
	 * 
	 */
	@Test
	public void testSellItemsForCapital() {
		store.SellItemsForCapital(100);
	}

}
