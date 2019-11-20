package GuessNumber;

import java.util.Scanner;

public class RandomNumberGame {
	
	RandomNumber rand;
	
	public RandomNumberGame(RandomNumber newRand) {
		rand = newRand;
	}
	
	public void printMenu() {
		System.out.print("Set Level\n");
		System.out.print("1. Easy\n");
		System.out.print("2. Medium\n");
		System.out.print("3. Hard\n");
		System.out.print("4. Expert\n");
		System.out.print("5. Custom");
	}
	
	public String getInput() {
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine()) { return s.nextLine(); }
		return null;
	}
	
	public String printCustomOptionMax() {
		System.out.print("Set max value: ");
		return getInput();
	}
	
	public String printCustomOptionMin() {
		System.out.print("Set min value: ");
		return null;
	}
	
	public void displayGuessNumber() {
		System.out.print("Guess number: ");
	}
}

