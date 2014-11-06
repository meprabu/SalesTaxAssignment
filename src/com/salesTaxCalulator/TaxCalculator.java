package com.salesTaxCalulator;

import java.util.HashSet;
import java.util.Set;

public interface TaxCalculator {

	public Set<ItemInterface> calculateTaxes(Set<ItemInterface> item);
	
}
