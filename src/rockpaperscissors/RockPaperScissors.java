package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {
	public static void run() {
		//Set up necessary code
		Scanner i = new Scanner(System.in);
		String l;
		boolean run = true;
		System.out.println("Welcome to rock paper scissors... \n"
				+ "You will type either \"rock\", \"paper\", or \"scissors\" \n"
				+ "then type \"again\" to play again or \"quit\" to quit");
		while(run) {
			l = i.nextLine();
		}
	}
}
