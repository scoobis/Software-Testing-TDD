package MathGame;

import java.util.Random;
import java.util.Scanner;

public class MathGame {
	
	MathQuestions question;
	
	public MathGame(MathQuestions a_question) {
		question = a_question;
	}
	
	public String printMenu() {
		System.out.print("Set Level\n");
		System.out.print("1. Simple\n");
		System.out.print("2. Medium\n");
		return getInput();
	}
	
	public String getInput() {
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine()) { return s.nextLine(); }
		return "-1";
	}
	
	public void setDifficulity(int option) {
		if (option == 1) {
			displayScore(simpleQuestions());
		} else if (option == 2) {
			displayScore(mediumQuestions());
		}
	}
	
	public void run() {
		setDifficulity(Integer.parseInt(printMenu()));
	}
	
	public int simpleQuestions() {
		Random rand = new Random();
		int score = 0;
		
		if (simpleAddition(rand.nextInt(50), rand.nextInt(50))) { score++; }
		if (simpleSubtraction(rand.nextInt(80-40) + 40, rand.nextInt(40))) { score++; }
		if (simpleMultiplication(rand.nextInt(10)+1, rand.nextInt(10)+1)) { score++; }
		if (simpleDivision(rand.nextInt(100-20) + 20, rand.nextInt(20)+1)) { score++; }
		int square = rand.nextInt(100);
		square = question.squareRoot(square);
		square = square * square;
		if (squareRoot(square)) { score++; }
		
		return score;
	}
	
	public int mediumQuestions() {
		Random rand = new Random();
		int score = 0;
		
		if (mediumAddition(rand.nextInt(30), rand.nextInt(30), rand.nextInt(30), rand.nextInt(30))) { score++; }
		if (mediumSubtraction(rand.nextInt(200-100) + 100, rand.nextInt(30), rand.nextInt(30), rand.nextInt(30))) { score++; }
		if (mediumMultiplication(rand.nextInt(10)+1, rand.nextInt(10)+1, rand.nextInt(10)+1)) { score++; }
		if (mediumDivision(rand.nextInt(200-100) + 100, rand.nextInt(10)+1, rand.nextInt(10)+1)) { score++; }
		
		int cube = rand.nextInt(1000);
		cube = question.cubeRoot(cube);
		cube = cube * cube * cube;
		if (cubeRoot(cube)) { score++; }
		
		return score;
	}
	
	public void displayScore(int score) {
		System.out.print("Your score: "+score+"/5\n");
	}
	
	public boolean simpleAddition(int num1, int num2) {
		int answer = question.simpleAddition(num1, num2);
		printSimple(num1, num2, "+");
		
		return validation(getInput(), answer);
	}
	
	public boolean simpleSubtraction(int num1, int num2) {
		int answer = question.simpleSubtraction(num1, num2);
		printSimple(num1, num2, "-");
		
		return validation(getInput(), answer);
	}
	
	public boolean simpleMultiplication(int num1, int num2) {
		int answer =  question.simpleMultiplication(num1, num2);
		printSimple(num1, num2, "*");
		
		return validation(getInput(), answer);
	}
	
	public boolean simpleDivision(int num1, int num2) {
		int answer =  question.simpleDivision(num1, num2);
		printSimple(num1, num2, "/");
		
		return validation(getInput(), answer);
	}
	
	public boolean squareRoot(int num) {
		int answer = question.squareRoot(num);
		System.out.print("\u221A"+num+ " = ");
		
		return validation(getInput(), answer);
	}
	
	public boolean mediumAddition(int num1, int num2, int num3, int num4) {
		int answer = question.mediumAddition(num1, num2, num3, num4);
		printMedium(num1, num2, num3, num4, "+");
		
		return validation(getInput(), answer);
	}
	
	public boolean mediumSubtraction(int num1, int num2, int num3, int num4) {
		int answer = question.mediumSubtraction(num1, num2, num3, num4);
		
		printMedium(num1, num2, num3, num4, "-");
		
		return validation(getInput(), answer);
	}
	
	public boolean mediumMultiplication(int num1, int num2, int num3) {
		int answer = question.mediumMultiplication(num1, num2, num3);
		
		printMediumShort(num1, num2, num3, "*");
		
		return validation(getInput(), answer);
	}
	
	public boolean mediumDivision(int num1, int num2, int num3) {
		int answer = question.mediumDivision(num1, num2, num3);
		
		printMediumShort(num1, num2, num3, "/");
		
		return validation(getInput(), answer);
	}
	
	public boolean cubeRoot(int num) {
		int answer = question.cubeRoot(num);
		
		System.out.print("Cube root of "+num+" = ");
		
		return validation(getInput(), answer);
	}
	
	private boolean validation(String guess, int answer) {
		return answer == Integer.parseInt(guess);
	}
	
	private void printSimple(int num1, int num2, String symbol) {
		System.out.print(num1 + " "+ symbol +" " + num2 + " = ");
	}
	
	private void printMedium(int num1, int num2, int num3, int num4, String symbol) {
		System.out.print(num1+ " " +symbol+ " " +num2+ " " +symbol+ " " +num3+ " " +symbol+ " " +num4+ " = ");
	}
	
	private void printMediumShort(int num1, int num2, int num3, String symbol) {
		System.out.print(num1+ " " +symbol+ " " +num2+ " " +symbol+ " " +num3+ " = ");
	}
}
