package com.bridgelabz.designpattern.behavioral.visitorpattern;
public interface ShoppingCartVisitor {
	  int visit(Book book);
	  int visit(Fruit fruit);

}
