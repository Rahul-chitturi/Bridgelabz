package com.bridgelabz.designpattern.behavioral.visitorpattern;

public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);

}
