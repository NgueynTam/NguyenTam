//Programmer: Tam Nguyen
//Class: CS145
//Date: 05/26/2023
//Assignment: Assignment 1 Word Search Generator
//Purpose: Program runs a word search generator

import java.util.*; 

public class WordSearchGenerator { // To format the grid
	private char[][] grid; 
	private boolean[][] sol; 
	private String[] words; 
	public void generate(String[] w) { 
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i].toLowerCase(); 
		}
		this.words = w;
		char[][] wordChars = setupGrid();
		for (int i = 0; i < wordChars.length; i++) {
			placeWord(wordChars, i); 
		}
		fillGrid();
	} // Grid length
	public String toString() {
		String result = "";
		for (int i = 0; i < grid.length; i++) { 
			for (int j = 0; j < grid[i].length; j++) { 
				result += " " + grid[i][j] + " ";
			}
			result += "\r\n";
		}
		return result;
	} // To show the solution 
	public String toSolution() {
		String result = "";
		for (int i = 0; i < grid.length; i++) { 
			for (int j = 0; j < grid[i].length; j++) { 
				if (sol[i][j]) { 
					result += " " + grid[i][j] + " ";
				} else {
					result += " X ";
				}
			}
			result += "\r\n";
		}
		return result;
	} // word placement randomizer
	private void placeWord(char[][] wordChars, int iter) {
		Random rand = new Random();
		int direction = rand.nextInt(3); 
		int[] pos = {0, 0};
		if (direction == 0) { 
			boolean placed = false;
			int attempts = 0; 
			while (!placed && attempts < 100) {
				pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length); 
				pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length); 
				placed = true;
				for (int i = 0; i < wordChars[iter].length; i++) {
					if (grid[pos[0] + i][pos[1]] != '\u0000' 
							&& grid[pos[0] + i][pos[1]] != wordChars[iter][i]) {
						placed = false;
						break;
					}
				}
				attempts++; 
			}
			if (placed) {
				for (int i = 0; i < wordChars[iter].length; i++) {
					grid[pos[0]][pos[1]] = wordChars[iter][i]; 
					sol[pos[0]][pos[1]] = true; 
					pos[0]++;
				}
			}
		} else if (direction == 1) { 
			boolean placed = false;
			int attempts = 0;
			while (!placed && attempts < 100) {
				pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				placed = true;
				for (int i = 0; i < wordChars[iter].length; i++) {
					if (grid[pos[0]][pos[1] + i] != '\u0000' 
							&& grid[pos[0]][pos[1] + i] != wordChars[iter][i]) {
						placed = false;
						break;
					}
				}
				attempts++;
			}
			if (placed) {
				for (int i = 0; i < wordChars[iter].length; i++) {
					grid[pos[0]][pos[1]] = wordChars[iter][i];
					sol[pos[0]][pos[1]] = true;
					pos[1]++;
				}
			}
		} else if (direction == 2) { 
			boolean placed = false;
			int attempts = 0;
			while (!placed && attempts < 100) {
				pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				placed = true;
				for (int i = 0; i < wordChars[iter].length; i++) {
					if (grid[pos[0] + i][pos[1] + i] != '\u0000' 
							&& grid[pos[0] + i][pos[1] + i] != wordChars[iter][i]) {
						placed = false;
						break;
					}
				}
				attempts++;
			}
			if (placed) {
				for (int i = 0; i < wordChars[iter].length; i++) {
					grid[pos[0]][pos[1]] = wordChars[iter][i];
					sol[pos[0]][pos[1]] = true;
					pos[1]++;
					pos[0]++;
				}
			}
		}
	} // setting up the grid, making sure words are within the range of generator
	private char[][] setupGrid() {
		char[][] wordChars = new char[words.length][];
		int longest = 8; 
		for (int i = 0; i < words.length; i++) {
			wordChars[i] = words[i].toCharArray();
			if (wordChars[i].length > longest) {
				longest = wordChars[i].length;
			}
		}
		if (words.length > longest) { 
			longest = words.length;
		}
		this.grid = new char[longest + 4][longest + 4]; 
		this.sol = new boolean[longest + 4][longest + 4]; 
		return wordChars;
	} // to fill the grid with words
	private void fillGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				Random rand = new Random();
				if (grid[i][j] == '\u0000') {
					grid[i][j] = (char) (rand.nextInt(26) + 97);
				}
			}
		}
	}
}