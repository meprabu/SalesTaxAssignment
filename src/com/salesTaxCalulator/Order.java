package com.salesTaxCalulator;



import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class Order {

	private Set<ItemInterface> taxedItemInterfaces;
	
	private Map<ItemInterface, Integer> ItemInterfaceQuantityMap;
	
	double taxtotal = 0;
	
	double total = 0;
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	public Order(Map<ItemInterface, Integer> ItemInterfaceQuantityMap) {
		this.ItemInterfaceQuantityMap = ItemInterfaceQuantityMap;
		printOrderInput(ItemInterfaceQuantityMap);
	}

	public Set<ItemInterface> getItems() {
		return ItemInterfaceQuantityMap.keySet();
	}
	
	
	public void setTaxedItems(Set<ItemInterface> taxedItemInterfaces) {
		this.taxedItemInterfaces = taxedItemInterfaces;
	}
	
	public int getQuantity(ItemInterface ItemInterface){
		return ItemInterfaceQuantityMap.get(ItemInterface);	
	}
	
	public double getTaxtotal() {
		return taxtotal;
	}

	public double getTotal() {
		return total;
	}

	private void printOrderInput(Map<ItemInterface, Integer> map) {
		System.out.println("Order input: ");
		for ( ItemInterface ItemInterface : map.keySet() ){
			System.out.println(map.get(ItemInterface) + " " + ItemInterface.getName() + " at " + df.format(ItemInterface.getShelfPrice()));
		}	
		System.out.println();
		
	}
	
	public void printOrderResults() {	
		System.out.println("Order results: ");
		for (ItemInterface ItemInterface : taxedItemInterfaces){		
			double ItemInterfacePrice = ItemInterface.getPrice();
			taxtotal += ItemInterfacePrice - ItemInterface.getShelfPrice();
			double subTotal = ItemInterfacePrice * getQuantity(ItemInterface);
			total += subTotal;
			System.out.println(getQuantity(ItemInterface) + " " + ItemInterface.getName() + ": " + df.format(subTotal));
		}
		total = Util.roundPrice(total);
		taxtotal = Util.nearest5Percent(taxtotal);
		System.out.println("Sales Taxes: "+taxtotal);
		System.out.println("Total: "+total);
		System.out.println();
		
	}
	
	

}