package com.bridgelabz.objectoriented.inventerymanagement.model;

public class Inventry {

	private String name;
	private long weight;
	private Double Price;

	public String getName() {
		return name;
	}

	public long getWeight() {
		return weight;
	}

	public Double getPrice() {
		return Price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int Weight) {
		this.weight = Weight;
	}

	public void setPrice(double d) {
		this.Price = d;
	}

	@Override
	public String toString() {
		return "name=" + name + ", weight=" + weight + ", price=" + Price ;
	}

}
