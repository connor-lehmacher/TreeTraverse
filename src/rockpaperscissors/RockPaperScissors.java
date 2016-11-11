package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {
	public static void run() {
		//Set up necessary code
		Scanner i = new Scanner(System.in);
		String l;
		int u;
		int c;
		int r;
		boolean run = true;
		String[] options = new String[]{"rock", "scissors", "paper"};
		String[] end = new String[]{"tie", "lose", "win"};
		System.out.println("Welcome to rock paper scissors... \n"
				+ "You will type either \"rock\", \"paper\", or \"scissors\" \n"
				+ "then type \"again\" to play again or \"quit\" to quit");
		while(run) {
			u = -1;
			while(u == -1) {
				l = i.nextLine();
				if(l.length() <= 4) {
					if(l.charAt(0) == 'r' || l.charAt(0) == 'R') {
						u = 0;
					}
				} else if(l.length() >= 6) {
					if(l.charAt(0) == 's' || l.charAt(0) == 'S') {
						u = 1;
					}	
				} else {
					if(l.charAt(0) == 'p' || l.charAt(0) == 'P') {
						u = 2;
					}
				}
				if(u == -1) {
					System.out.println("Try again you messed up");
				}
			}
			
			c = (int)(Math.random() * 3.0);
			System.out.println(options[u]);
			System.out.println(options[c]);
			r = (u - c + 3) % 3;
			System.out.println(end[r]);
		}
	}
}
