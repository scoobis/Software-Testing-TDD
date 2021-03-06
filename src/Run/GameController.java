package Run;

import java.util.Scanner;

import GuessNumber.RandomNumberGame;
import MathGame.MathGame;

public class GameController {
	
	MathGame mathGame;
	RandomNumberGame numberGame;
	
	public GameController(MathGame mathGame, RandomNumberGame numberGame) {
		this.mathGame = mathGame;
		this.numberGame = numberGame;
	}
	
	public String printMainMenu() {
		System.out.print("Pick a game!\n");
		System.out.print("1. MathGame\n");
		System.out.print("2. Guess the number\n");
		System.out.print("3. Exit\n");
		return getInput();
	}
	
	public String getInput() {
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine()) { return s.nextLine(); }
		return "-1";
	}
	
	public boolean option() {
		int option = Integer.parseInt(printMainMenu());
		if (option == 1) { runMath(); }
		else if (option == 2) { runGuessNumber(); }
		else if (option == 3) { 
		System.out.print("Exit...");
		return false; 
		}
		return true;
	}
	
	public void runMath() {
		mathGame.run();
	}
	
	public void runGuessNumber() {
		numberGame.run();
	}
}
