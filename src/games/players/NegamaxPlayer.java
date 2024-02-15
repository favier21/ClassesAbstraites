package games.players;
import games.genericgames.Game;
import java.util.ArrayList;
public class NegamaxPlayer implements Player{

	
	public NegamaxPlayer(){}
	
	
	
	public int evaluate(Game situation){
		if (situation.isOver()){
			if(situation.getWinner() == situation.getCurrentPlayer())
				return 1;
			
			else if(situation.getWinner() == null)
				return 0;
			return -1;
		}
		int res = -2;
		Game s2;
		int v;
		for(int c : situation.validMoves()){
			//s'
			s2 = situation.copy();
			s2.execute(c);
			
			v = -(evaluate(s2));
			if(res == -2|| v > res)
				res = v;	
 		}
 		return res;
		
	}
	
	
	
	@Override
	public int chooseMove(Game jeu){
		int meilleureValeur = -2;
		int meilleurCoup = -2;		
		Game s2;
		int v;
		for(int c : jeu.validMoves()){
			s2 = jeu.copy();
			s2.execute(c);
			v = -(evaluate(s2));
			
			if(meilleureValeur == -2 || v > meilleureValeur){
				meilleureValeur = v;
				meilleurCoup = c;	
			}
			
		}
		return meilleurCoup;
	
	}
	@Override
	public String toString(){
		return "NegamaxAI";
	
	}


}
