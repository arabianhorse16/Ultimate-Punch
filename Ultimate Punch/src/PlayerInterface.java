//********************************************************************************************************
// PlayerInterface.java      Author: Mohammad Khan      Publication Date: 08/05/2018
//
// Represents a battle between the user and the computer with the user capable of attacking and blocking.
//********************************************************************************************************

import java.util.*;

public class PlayerInterface {
	//-----------------------------------------------------------------
	// Shows the mechanics and dialogue utilized throughout the fight.
	//-----------------------------------------------------------------
	public static void main (String[] args) { 
		int playerHealth = 50, computerHealth = 50; // Represents the users and computer's health respectively.
		
		Random rand = new Random();
		
		Scanner scan = new Scanner(System.in);
		String action; 

		System.out.println("Welcome to Ultimate Punch!!!" + "\n" + "Get ready to fight!"); // Introduction to the game when the program runs.
		System.out.println();
		
		// Represents the battle mechanics between the user and the computer, and determines who will attack in each turn.
		while (computerHealth > 0 && playerHealth > 0) { // As long as neither player has a health of zero or below, the battle ensues (while loop continues).
			
			System.out.println("Press enter to Punch or anything else to Block."); // Dialogue that is given during each turn for the user.
			action = scan.nextLine();
			
			int turnToPunch = rand.nextInt(2) + 1; // Determines who swings in each turn (who delivers damage) using a random number of 1 or 2.
			
			// Determines that the user player will deliver damage to the computer.
			if (turnToPunch == 1) {
				int damage = rand.nextInt(10) + 1; // Damage that is delivered is between a value of 1 - 10 by the user.
				
				// Determines that if "turnToPunch" = 1, then the player can attack if he/she presses enter.
				if (action.equals("")) {
					System.out.println("You swung first and your punch caused " + damage + " damage to the computer."); 
					
					// Dictates that after an attack is done by the user, the computer's health is given a new value relating to the user's damage.
					computerHealth = computerHealth - damage;
					System.out.println("Your health: " + playerHealth + "\n" + "The computer's health: " + computerHealth);
					
					System.out.println("---------------------------------------------------------"); // Separates the dialogue of each turn.
				}
				// Represents any input key other than enter which dictates that the user is blocking. 
				else {
					damage = 0; // When the user blocks, 0 damage is taken.
					System.out.println("You have blocked and taken " + damage + " damage.");
					System.out.println("Your health: " + playerHealth + "\n" + "The computer's health: " + computerHealth);
					
					System.out.println("---------------------------------------------------------"); // Separates the dialogue of each turn.
				}
			}
			// Represents the computer attacking if "turnToPunch" = 2.
			else {
				// Shows that if the player chooses to block when the computer is able to hit, 0 damage is taken.
				if (!action.equals("")) {
					int damage = 0;
					System.out.println("You have blocked and taken " + damage + " damage.");
					System.out.println("Your health: " + playerHealth + "\n" + "The computer's health: " + computerHealth);
					
					System.out.println("---------------------------------------------------------"); // Separates the dialogue of each turn.
				}
				// Shows that if the user chooses to attack (enter input), the user will receive damage since "turnToPunch" = 2. 
				else {
					int damage = rand.nextInt(10) + 1; // Damage that is delivered is between a value of 1 - 10 by the computer.
					
					System.out.println("The computer swung first and caused " + damage + " damage to you.");
					
					// Dictates that after an attack is done by the computer, the user's health is given a new value relating to the computer's damage.
					playerHealth = playerHealth - damage;
					System.out.println("Your health: " + playerHealth + "\n" + "The computer's health: " + computerHealth);
				
					System.out.println("---------------------------------------------------------"); // Separates the dialogue of each turn.
				}
			}
		}
		if (computerHealth < 1) {
			System.out.println("Congrats! You won the bout!"); // Dialogue that's given when the user beats the computer.
		}
		else { 
			System.out.println("Better luck next time buddy. Keep training."); // Dialogue that's given when the computer beats the user.
		}
	}
}
