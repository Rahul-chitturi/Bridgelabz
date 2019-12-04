package com.bridgelabz.designpattern.behavioral.visitorpattern;

public class ShoppingCartClient {
public static void main(String[] args) {
	ItemElement[] items = new ItemElement[]{new Book(20,"1234"),new Book(10,"4567"),new Fruit(10,2,"bannana"),new Fruit(4,4,"apple")};
	int total = calculatePrice(items);
	System.out.println("Total Cost = "+total);
}
private static int calculatePrice(ItemElement[] items) {
	ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
int sum=0;
for(ItemElement item : items) {
	sum = sum+item.accept(visitor);
}
return sum;
}
}
