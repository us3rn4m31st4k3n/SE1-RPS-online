package Behaviour;
import java.util.*;

public class MovesAndBehaviour {

	public boolean beatsEnemyPlayer() {
		if(player.getType()==Rock && enemy.getType()==Paper) {
			return false
		}
		if(player.getType()==Rock && enemy.getType()==Scissors) {
			return true
		}
		if(player.getType()==Rock && enemy.getType()==Rock) {
			chooseNewWeapon();
		}
		if(player.getType()==Scissors && enemy.getType()==Paper) {
			return true
		}
		if(player.getType()==Scissors && enemy.getType()==Rock) {
			return false
		}
		if(player.getType()==Scissors && enemy.getType()==Scissors) {
			chooseNewWeapon();
		}
		if(player.getType()==Paper && enemy.getType()==Scissors) {
			return false
		}
		if(player.getType()==Paper && enemy.getType()==Rock) {
			return true
		}
		if(player.getType()==Paper && enemy.getType()==Paper) {
			chooseNewWeapon();
		}
		if(enemy instanceof trap) {
			System.out.println("It's a trap!");
			return false
		}
		if(enemy instanceof flag) {
			System.out.println("You won!");
			break;
		}
		
	
	}
	
	public void chooseNewWeapon() {
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("It's a draw! Select new weapon \n Rock(1) Paper(2) or Scissors(3) ?");
		System.out.println("Type in the number of your chosen weapon:");
		int chosenWeapon = scan.nextInt();
		
		if(chosenWeapon == 1) {
			setType(Rock);
		}
		if(chosenWeapon == 2) {
			setType(Paper);
		}
		if(chosenWeapon == 3) {
			setType(Scissors);
		}
		else {
			System.out.println("That does not exist.");
			chooseNewWeapon();
		}
		
	}
	
	public void outcome() {
		
		if(beatsEnemyPlayer == true) {
			System.out.println("You lost your " player.getType());
			board.getContent(player.getXPosition(), player.getYPosition) = null;
			positionFree(player.getXPosition, player.getYPosition) = true; //if other definition of free field exist this is obsolete
			
		}
		else if(beatsEnemyPlayer == false) {
			System.out.println("Enemy lost his " enemy.getType());
			board.getContent(enemy.getXPosition(), enemy.getYPosition) = null;
			positionFree(player.getXPosition, player.getYPosition) = true; // see above
		}
	}
	
}
