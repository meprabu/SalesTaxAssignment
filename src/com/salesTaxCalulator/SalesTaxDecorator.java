package com.salesTaxCalulator;


public class SalesTaxDecorator extends TaxDecorator {
	
	ItemInterface itemToDecorate;
	
	final double rate = 0.1;

	public SalesTaxDecorator (ItemInterface item){
		super(item);
		this.itemToDecorate = item;		
	}

	@Override
	double getRate() {
		return this.rate;
	}
	
	public boolean isImported() {
		return itemToDecorate.isImported();
	}

	public String getName() {
		return itemToDecorate.getName();
	}

	public double getShelfPrice() {
		return itemToDecorate.getShelfPrice();
	}

	public int getType() {
		return itemToDecorate.getType();
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getType();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		else if (obj instanceof ItemInterface){
			return (((ItemInterface)obj).hashCode() == this.hashCode());

		}
		else return false;
	}
	
}