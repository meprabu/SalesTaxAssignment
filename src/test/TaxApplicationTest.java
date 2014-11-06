package test;

import java.util.HashMap;
import java.util.Map;

import com.salesTaxCalulator.ItemInterface;
import com.salesTaxCalulator.Order;
import com.salesTaxCalulator.BuyOrder;
import com.salesTaxCalulator.SetItem;

import junit.framework.TestCase;
import static com.salesTaxCalulator.BuyOrder.*;

public class TaxApplicationTest extends TestCase {

	BuyOrder buyOrder = BuyOrder.getInstance();
	
	
	public void testTotal1Correct() {
		
		double bookShelfPrice = 12.49;
		double cdShelfPrice = 14.99;
		double chocolateBarShelfPrice = 0.85;	
		double expectedTotal = 29.83;
		SetItem book = new SetItem("Book", TYPE_BOOK, bookShelfPrice);
		SetItem musicCD = new SetItem("Music CD", TYPE_OTHER, cdShelfPrice);
		SetItem chocolateBar = new SetItem("Chocolate Bar", TYPE_FOOD, chocolateBarShelfPrice);
		
		Map<ItemInterface, Integer> cashierInput = new HashMap<ItemInterface, Integer>();		
		cashierInput.put(book, 1);
		cashierInput.put(musicCD, 1);
		cashierInput.put(chocolateBar, 1);
		Order order = new Order(cashierInput);
		Order newOrder = buyOrder.makeOrder(order);
		
		assertEquals(expectedTotal, newOrder.getTotal());

	}
	
	public void testTotal2Correct(){
		
		double importedBoxOfChocolatePrice = 10.00;
		double importedParfumePrice = 47.50;	
		double expectedTotal = 65.15;		
		SetItem importedBoxOfChocolate = new SetItem("Imported box of chocolates", TYPE_FOOD, importedBoxOfChocolatePrice);
		importedBoxOfChocolate.setImported(true);
		SetItem importedParfume = new SetItem("Imported bottle of parfume", TYPE_OTHER, importedParfumePrice);
		importedParfume.setImported(true);
		
		Map<ItemInterface, Integer> cashierInput = new HashMap<ItemInterface, Integer>();
		cashierInput.put(importedBoxOfChocolate, 1);
		cashierInput.put(importedParfume, 1);
		Order order = new Order(cashierInput);
		Order newOrder = buyOrder.makeOrder(order);
		
		assertEquals(expectedTotal, newOrder.getTotal());
	}
	
	public void testTotal3Correct(){
		double importedParfumePrice = 27.99;	
		double parfumePrice = 18.99;
		double headAchePillsPrice = 9.75;	
		double importedBoxOfChocolatePrice = 11.25;
		double expectedTotal = 74.68;	
		
		SetItem importedParfume = new SetItem("Imported bottle of parfume", TYPE_OTHER, importedParfumePrice);
		importedParfume.setImported(true);
		SetItem parfume = new SetItem("Bottle of parfume", TYPE_OTHER, parfumePrice);
		SetItem headAchePills = new SetItem("Packet of headache pills", TYPE_MEDICAL, headAchePillsPrice);
		SetItem importedBoxOfChocolate = new SetItem("Imported box of chocolates", TYPE_FOOD, importedBoxOfChocolatePrice);
		importedBoxOfChocolate.setImported(true);
		
		Map<ItemInterface, Integer> cashierInput = new HashMap<ItemInterface, Integer>();
		cashierInput.put(importedParfume, 1);
		cashierInput.put(parfume, 1);
		cashierInput.put(headAchePills, 1);
		cashierInput.put(importedBoxOfChocolate, 1);
		Order order = new Order(cashierInput);
		Order newOrder = buyOrder.makeOrder(order);
		
		assertEquals(expectedTotal, newOrder.getTotal());
	}
	
	
	public static void main(String args[]) {
	      org.junit.runner.JUnitCore.main("com.salestaxes.test.TaxApplicationTest");
	    }

	
}