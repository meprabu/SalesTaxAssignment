package com.salesTaxCalulator;

import java.util.Set;

public class BuyOrder {
	
	static final public int TYPE_BOOK = 1;
	static final public int TYPE_FOOD = 2;
	static final public int TYPE_MEDICAL = 3;
	static final public int TYPE_OTHER = 4;
	
	TaxCalculator taxCalculator;
	
	private static BuyOrder instance = null;
	   
	protected BuyOrder() {
	      
	}
	
	public static BuyOrder getInstance() {
	    if(instance == null) {
	        instance = new BuyOrder();
	        instance.taxCalculator = TaxCalculatorFactory.getInstance();
	    }
	    return instance;
	}

    public Order makeOrder (Order order) {
    	order = updateOrderWithTaxes(order);
    	order.printOrderResults();
    	return order;
    }

	private Order updateOrderWithTaxes(Order order) {

		Set<ItemInterface> taxedItems = taxCalculator.calculateTaxes(order.getItems());
    	order.setTaxedItems(taxedItems);
    	return order;
	}
    
}
