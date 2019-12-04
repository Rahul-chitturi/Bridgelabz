package com.bridgelabz.designpattern.behavioral.visitorpattern;

public class Fruit implements ItemElement{
	private int pricePerKg;
	private int weight;
	private String name;
	
	public Fruit(int priceKg,int wt,String nm)
	{
		this.pricePerKg=priceKg;
		this.weight=wt;
		this.name=nm;
	}
	
	public int getpricePerKg()
	{
		return pricePerKg;
	}

	public int getweight()
	{
		return weight;
	}
	public String getname()
	{
		return name;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		 		return visitor.visit(this);
	}
}
