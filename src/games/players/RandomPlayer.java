package games.players;
import games.genericgames.Game;
import java.util.Random;

public class RandomPlayer implements Player {

	 private Random rand;
	 
	 private int indiceRand;

	 public RandomPlayer(Random rand){
	 this.rand = rand;
	 this.indiceRand= 0;
	 }
	 @Override
	 public int chooseMove(Game jeu){
	 	 this.indiceRand= rand.nextInt(jeu.validMoves().size());
	 	return jeu.validMoves().get(this.indiceRand);

	 }
	 @Override
	 public String toString(){

		 return ("Joueur aléatoire n° " + this.hashCode());

	 }

}
