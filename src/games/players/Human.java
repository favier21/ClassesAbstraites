package games.players;
import games.genericgames.Game;
import java.util.Scanner;
public class Human implements Player{
	
	private String nom;
	
	private Scanner scan;
	
	public Human(String nom, Scanner scan){
		this.nom = nom;
		this.scan = scan;
	}
	
	@Override
	public int chooseMove(Game jeu){
		int action = Integer.parseInt(this.scan.next());
		
		if (!jeu.isValid(action)){
			while (!jeu.isValid(action)){
				System.out.println("ça marche pas");
				action = Integer.parseInt( this.scan.next());
			}
		}
		return action;
	}
	
	@Override
	public String toString(){
		return this.nom;
	
	}


}
