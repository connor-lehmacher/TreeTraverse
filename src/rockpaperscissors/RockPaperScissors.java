package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {
	private static Scanner i;

	//Just run run() to play game
	public static void run() {
		i = new Scanner(System.in);
		String l;
		int u;
		int c;
		int r;
		boolean run = true;
		String[] options = new String[]{"rock", "scissors", "paper"};
		String[] end = new String[]{"tie", "lose", "win"};
		
		//Introduction
		System.out.println("Welcome to rock paper scissors... \n"
				+ "You will type either \"rock\", \"paper\", or \"scissors\" \n"
				+ "then type \"again\" to play again or \"quit\" to quit");
		
		//Logic While Loop
		while(run) {
			//Note the nested while loop
			//The run == true makes sure the outer loop runs
			//u is for the inner loop which makes sure people don't type stupid stuff
			u = -1;
			while(u == -1) {
				//Scan line
				l = i.nextLine();
				if(l.length() <= 4) {
					if(l.charAt(0) == 'r' || l.charAt(0) == 'R') {
						//Rock
						u = 0;
					}
					if(l.charAt(0) == 'q' || l.charAt(0) == 'Q') {
						//Quit
						u = -2;
					}
				} else if(l.length() >= 6) {
					if(l.charAt(0) == 's' || l.charAt(0) == 'S') {
						//Scissors
						u = 1;
					}	
				} else {
					if(l.charAt(0) == 'p' || l.charAt(0) == 'P') {
						//Paper
						u = 2;
					}
				}
				//if the user fails
				if(u == -1) {
					System.out.println("Try again you messed up");
				}
			}
			
			//quits the big logic loop if quit is typed successfully
			if(u == -2) run = false;
			
			c = (int)(Math.random() * 3.0);
			//Printing user and computer answers
			System.out.println(options[u]);
			System.out.println(options[c]);
			//win/lose condition its so cool!
			//This is the Jensen Algorithm
			r = (u - c + 3) % 3;
			System.out.println(end[r]);
		}
		
		System.out.println("Goodbye!");
	}
}
