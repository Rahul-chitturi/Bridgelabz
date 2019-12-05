package com.bridgelabz.deckofcards;

import java.util.Random;

import com.bridgelabz.deckofcards.util.MyQueue;



/*
 * Purpose: Sort by Rank and maintain the cards in a Queue implememted using LinkedList
 * @author: Amit
 * @since: 24-11-2019
 * 
 * */
public class SortCardByRanks {
	MyQueue<Player> playerQueue;	
	int[][] cardsArray;	
	public static void main(String[] args) {
		
		SortCardByRanks extended = new SortCardByRanks();	
		extended.start();	
		extended.dequeuePlayers();	
	}
	
	/** initialises queue and and adds players**/
	void start() {
		playerQueue = new MyQueue<Player>();
		cardsArray = new int[4][13];
		for(int i = 0; i < 4; i++) {
			addPlayers();
		}
	}
	
	/** creates a player and allots cards **/
	void addPlayers() {
		Player player = new Player();		
		for (int i = 0; i < 9; i++) {
			allotCard(player);
		}
		player.enqueueCards();	//	sorts the allotted cards
		playerQueue.enqueue(player);	//	enqueues the player
	}
	
	/** Generates a random a card and allots it to player
	 * @param-type: Takes Player type argument
	 * @return-type: Doen't return anything 
	 *  **/
	void allotCard(Player player) {
		Random random = new Random();	
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		
//		checks if the card is already allotted
		if(cardsArray[suit][rank] == 0) {	
			player.addCard(suit, rank);	// adds card to player
			cardsArray[suit][rank] = 1;	//	marks card as allotted
		}
		else {	//	card is already allotted. generates new card 
			allotCard(player);
		}
	}
	
	/** dequeues players **/
	void dequeuePlayers() {
		for(int i = 0; i < 4; i++) {
			Player player = playerQueue.dequeue();
			System.out.println("Player " + (i+1) + " cards:");
			printPlayerCards(player);
			System.out.println();
		}
	}
	
	/** prints player's cards**/
	void printPlayerCards(Player player) {
		for (int i = 0; i < 9; i++) {
			Card card = player.getCard();
			System.out.print(card.getSuit() + " " + card.getRank() + "\t");
		}
		System.out.println();
	}
}
