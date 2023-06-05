//Programmer: Tam Nguyen
//Class: CS145
//Date: 05/26/2023
//Assignment: Assignment 1 Word Search Generator
//Purpose: Program runs a word search generator

import java.util.*; 
public class WordSearchGeneratorMain {
	public static void main(String[] args) {
		boolean generated = false; 
		try (Scanner console = new Scanner(System.in)) {
			String choice;
			WordSearchGenerator search = new WordSearchGenerator(); 
			do { // swtich case to assign letters to options
				printIntro();
				choice = console.next();
				choice = choice.toLowerCase(); 
				switch (choice) {
				case "g":
					setUpGenerator(search, console);
					generated = true; 
					break;
				case "p":
					if (generated) { 
						print(search);
					}
					break;
				case "s":
					if (generated) { 
						showSolution(search);
					}
					break;
				default: 
					System.out.println("Not a valid option. Try again.");
					break;
				}
			} while (!choice.equals("q")); 
		}
	} // print out options
	public static void printIntro() {
		System.out.println("Welcome to my word search generator!");
		System.out.println("This program will allow you to generate your own word search puzzle");
		System.out.println("Please select and option:");
		System.out.println("Generate a new word search (g)");
		System.out.println("Print out your word search (p)");
		System.out.println("Show the solution to your word search(s)");
		System.out.println("Quit the prograrm (q)");
	} // Inputting words and to finish words
	public static ArrayList<String> setUpGenerator(WordSearchGenerator search, Scanner console) {
		System.out.println("Enter words line by line. When finished, type \"q\"");
		String word = console.next();
		ArrayList<String> wordsAR = new ArrayList<String>();
		do {
			wordsAR.add(word);
			word = console.next();
		} while (!word.equals("q"));
		String[] words = new String[wordsAR.size()];
		wordsAR.toArray(words);
		search.generate(words);
		return wordsAR;
	} // Print out word search 
	public static void print(WordSearchGenerator ws) {
		System.out.println(ws);
	} // Print out solution
	public static void showSolution(WordSearchGenerator ws) {
		System.out.println(ws.toSolution());
	}
}