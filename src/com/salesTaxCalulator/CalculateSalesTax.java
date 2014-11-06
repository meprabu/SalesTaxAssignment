package com.salesTaxCalulator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CalculateSalesTax implements TaxCalculator {
	
	private Set<Integer> exemptTypes = new HashSet<Integer>();
	

	CalculateSalesTax(Set<Integer> exemptTypes){
		this.exemptTypes = exemptTypes;
	}
	
	CalculateSalesTax(){

	}
	
	public Set<ItemInterface> calculateTaxes(Set<ItemInterface> items) {
		
		Set<ItemInterface> taxedItems = new HashSet<ItemInterface>();
		
		Iterator<ItemInterface> itItem = items.iterator();
		while (itItem.hasNext() ){
			ItemInterface item = itItem.next();
			if (item.isImported()) item = new ImportTaxDecorator(item);
			if (!exemptTypes.contains(item.getType())) item = new SalesTaxDecorator(item);
			taxedItems.add(item);
		}

		return taxedItems;
			
	}

	
}
