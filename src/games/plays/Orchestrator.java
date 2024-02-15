package games.plays;
import games.genericgames.Game;
import games.players.Player;
public class Orchestrator {

	private Game jeu;
	
	private Player j;

	public Orchestrator(Game jeu){

	this.jeu = jeu;
	}


	public void play(){

	while(!this.jeu.isOver()){
		this.j =this.jeu.getCurrentPlayer();
		System.out.println("Le joueur actuel est :");
		System.out.println(this.j);
		System.out.println(this.jeu.situationToString());
		
		this.jeu.execute(this.j.chooseMove(this.jeu));
		

	}
	
	System.out.println("Le joueur gagnant est le joueur:");
	System.out.println(this.jeu.getWinner());
	
	System.out.println(this.jeu.situationToString());
	
	}



}
