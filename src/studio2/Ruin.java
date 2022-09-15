package studio2;
import java.util.Scanner;
import java.util.Random;

public class Ruin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner in = new Scanner(System.in);

		System.out.println("What would you like your start amount to be?");
		double startAmount = in.nextDouble();
		//System.out.println (startAmount);

		System.out.println("What would you like your win limit to be?");
		double winLimit = in.nextDouble();
		//System.out.println (winLimit);

		System.out.println("What would you like your winChance to be?");
		double winChance = in.nextDouble();

		for (int totalSimulations = 0; startAmount < winLimit; totalSimulations += 1) {

			boolean oddsWinning  = Math.random ()>winChance; // whether or not you're winning. 


			if  (oddsWinning == true ) {

				startAmount = startAmount +1.0;
				System.out.println(" You won! You now have $" +  startAmount + "for simulation " + totalSimulations); 

				if (startAmount == winLimit) {
					System.out.println(" You Won! You have reached your win limit"); 
					System.out.println (totalSimulations + " simulations number for the day");

				}
			}

			else if  (oddsWinning == false) {
				startAmount= startAmount -1.0;
				System.out.println(" You lost! You now have $" + startAmount +  "for simulation " + totalSimulations); 

				if (startAmount == 0) {
					System.out.println(" You lost! You have $0 left. Game over"); 
					System.out.println (" You have " + totalSimulations + " for the day");
				}	
			}
		}
		double a = ((1.0-winChance)/(winChance));
		double expectedRuin = 0;
		if (winChance == 0.5) {
			expectedRuin = (1.0 - (startAmount/winLimit));
			System.out.println ("Expected ruin rate = " + expectedRuin);
		}
		else {
			expectedRuin = (Math. pow(a,startAmount) - Math. pow(a,winLimit)) / (1.0- Math. pow(a, winLimit));      
			System.out.println ("Expected ruin rate = " + expectedRuin);
		}	
	}
}
