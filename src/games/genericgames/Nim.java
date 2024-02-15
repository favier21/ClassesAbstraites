package games.genericgames;
import games.players.Player;
import java.util.ArrayList;
public class Nim extends AbstractGame implements Game {

	private int n;

	private int k;

	private int resteAllumettes;

	public Nim(int n, int k, Player j1, Player j2) {
		super(j1,j2);
		//nombre d'allumettes de départ
		this.n = n;
		//nombre maximum d'allumettes maximales retirables
		this.k = k;
		//nombre d'allumettes restantes
		this.resteAllumettes = this.n;

	}


	public int getInitialNbMatches() {
		//renvoie le nombre d'allumettes de départ
		return this.n;
	}

	public int getCurrentNbMatches() {
		//renvoie le nombre d'allumettes restantes
		return this.resteAllumettes;
	}
	
	public String situationToString(){
		//renvoie la situation afin d'être affiché
		return "Il reste "+this.getCurrentNbMatches()+" allumettes";
	}
	
	public String moveToString(int move){
		return "";
	}
	public ArrayList<Integer> validMoves(){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i <= this.n; i++) {
			if(isValid(i)){
			res.add(i);
			}
		}
		return res;
	
	
	}
	 
	 
	 
	
	@Override
	public void doExecute(int nbAllumettes){
		//retire le nombre d'allumettes mis en argument,puis change de joueur
		this.resteAllumettes -= nbAllumettes;
		}



	public boolean isValid(int nbAllumettes){
		//renvoie true si le nombre d'allumettes à retirer en argument est valide
		//nbAllumettes est valide si il est suppérieur à 0 et inférieur au nombre maximum d'allumettes maximales retirables
		if((nbAllumettes>0 && nbAllumettes<=this.k) && this.resteAllumettes-nbAllumettes>=0){

			return true;
		}
		else{

			return false;

		}

	}

	public boolean isOver(){
		//renvoie true si le nombre d'allumettes restantes est 0
		if(this.resteAllumettes == 0){

			return true;

		}
		else{

			return false;
		}

	}
	public Player getWinner(){
		//renvoie le joueur actuel si la partie est terminée
		//si la partie n'est pas terminée, renvoie null
		if(this.isOver()){
			if(this.getCurrentPlayer() == this.j1){

				return this.j1;

			}
			else{
				return this.j2;
			}
		}
		else{
			return null;
		}
	}
	public Nim copy(){

		Nim res = new Nim(this.n, this.k, this.j1,this.j2);
		res.resteAllumettes = this.getCurrentNbMatches();
		res.joueurActuel = super.joueurActuel;
		return res;



	}

}
