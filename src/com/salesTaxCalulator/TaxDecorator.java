package com.salesTaxCalulator;

public abstract class TaxDecorator implements ItemInterface{
    
	protected ItemInterface item;
	
	protected double rate;
	
	abstract double getRate();
	
	public TaxDecorator(ItemInterface item){
		this.item = item;
	}
	
	public double getPrice(){
		double salesTax = Util.nearest5Percent(this.item.getShelfPrice() * this.getRate());	
		return Util.roundPrice(this.item.getPrice() + salesTax);
	}
	
}