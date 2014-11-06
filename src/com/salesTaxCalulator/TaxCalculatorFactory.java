package com.salesTaxCalulator;

import java.util.HashSet;
import java.util.Set;

import static com.salesTaxCalulator.BuyOrder.*;

public class TaxCalculatorFactory {

	protected TaxCalculatorFactory(){
		
	}
	
	static private TaxCalculator instance = null;
	
	static public TaxCalculator getInstance(){
		
		if(instance == null){
			Set<Integer> exemptTypes = new HashSet<Integer>();
			exemptTypes.add(TYPE_BOOK);
			exemptTypes.add(TYPE_FOOD);
			exemptTypes.add(TYPE_MEDICAL);

			instance = new CalculateSalesTax(exemptTypes);
		}
		
		return instance;
	}
	
}
