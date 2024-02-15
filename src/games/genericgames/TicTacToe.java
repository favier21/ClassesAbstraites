package games.genericgames;
import games.players.Player;
import java.util.ArrayList;

public class TicTacToe extends AbstractGame implements Game{

	private String[][] tab;

	public TicTacToe(Player j1, Player j2) {
		super(j1,j2);
		//déclaration du tableau tab composé de caractères
		this.tab = new String[3][3];

		//création du tableau de taille 3 x 3
		for (int v = 0; v < tab.length; v++) {

			for (int i = 0; i < 3; i++) {
				tab[v][i]=".";
			}

		}
		//joueur actuel
		this.joueurActuel=this.j1;

	}

	public String[][] getTableau(){
		//renvoie le tableau
		return this.tab;

	}
	public int getLigne(int x){
		//renvoie le n° de la ligne du tableau corespondant à l'entier inceré en argument
		if(x<3){
		return 0;
		}
		else if(x<6){
		return 1;
		}
		else{
		return 2;
		}

	}
	public int getColone(int x){
		//renvoie le n° de la colone du tableau corespondant à l'entier inceré en argument
		if(x%3==0)
		{
			return 0;
		}
		else if(x%3 ==1)
		{
			return 1;
		}
		else
		{
			return 2;
		}

	}
	@Override
	public void doExecute(int coup){
		//modifie la grille du tictactoe en fonction de l'entier inceré en argument
		String mod;

		if(this.getCurrentPlayer()==this.j1){
			mod="X";
		}
		else{
			mod="O";
		}
		this.tab[this.getLigne(coup)][this.getColone(coup)]=mod;
	}

	public boolean isValid(int coup){
		//renvoie true si le coup entré en argument est valide sur la grille
		return this.tab[this.getLigne(coup)][this.getColone(coup)]==".";

	}

	public ArrayList<Integer> validMoves(){
		//renvoie la liste des coups valides
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < 9; i++) {
			if(isValid(i)){
			res.add(i);
			}
		}
		return res;

	}
	
	
	public String situationToString(){
		this.afficher();
		
		return "";
	}
	
	public String moveToString(int coup){
		//renvoie une chaine de caractère décrivant la ligne et la colone d'un coup
		return "("+(this.getLigne(coup)+1)+","+(this.getColone(coup)+1)+")";
	}
	

	public boolean wins(Player j,int row,int column,int deltaRow,int deltaColumn){
		//renvoie true si le joueur inceré en argument à gagné
		String s;
		if(j==this.j1){
			s="X";
		}
		else{
			s="O";
		}

		if(this.tab[row][column]==s ){
			if(this.tab[row+deltaRow][column+deltaColumn]==s){
				if(this.tab[row+2*deltaRow][column+2*deltaColumn]==s){
					return true;
				}

			}


		}
		return false;
	}

	public Player getWinner(){
		//renvoie le joueur gagnant en testant toutes les combinaisons possibles sur la grille

		for (int i = 0; i < 3 ; i++) {
			//test pour le joueur1
				/*test des lignes*/
			if(this.wins(this.j1,i,0,0,1)){
				return this.j1;
			}
				/*test des colones*/
			else if(this.wins(this.j1,0,i,1,0)){
				return this.j1;
			}
			//test pour le joueur2
				/*test des lignes*/
			if(this.wins(this.j2,i,0,0,1)){
				return this.j2;
			}
				/*test des colones*/
			else if(this.wins(this.j2,0,i,1,0)){
				return this.j2;
			}

		}
		//test des diagonales

		if(this.wins(this.j1,0,0,1,1)||this.wins(this.j1,0,2,1,-1)){
			return this.j1;
		}
		if(this.wins(this.j2,0,0,1,1)||this.wins(this.j2,0,2,1,-1)){
			return this.j2;
		}
		//renvoie null si il n'y à pas de gagnant
		return null;
	}

	public boolean isOver(){
		//renvoie true si la partie est terminée
		if(this.getWinner()!=null){
			return true;
		}

		if(this.validMoves().size()!=0){
			return false;
			}

		return true;



	}
	public void afficher(){
		//affiche la grille
		for (int ligne = 0; ligne < this.getTableau().length; ligne++) {

			for (int colone = 0; colone < 3; colone++) {
				System.out.print(this.getTableau()[ligne][colone]+" ");
			}
			 System.out.println();
		}

	}
	public TicTacToe copy(){

		TicTacToe res = new TicTacToe(this.j1,this.j2);
		res.tab = new String[3][3];
		for (int v = 0; v < this.tab.length; v++) {

			for (int i = 0; i < 3; i++) {
				res.tab[v][i]=this.tab[v][i];
			}

		}
		res.joueurActuel = super.joueurActuel;
		return res;



}



}
