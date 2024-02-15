package games.genericgames;
import games.players.Player;
import games.players.Human;
import games.players.RandomPlayer;
import games.players.NegamaxPlayer;
import games.plays.Orchestrator;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main{
	private static Player playertype(Scanner scanner,String NomTypeJoueur){
		Player player;
		if(NomTypeJoueur.equalsIgnoreCase("Human")){
			System.out.println("Le nom du joueur est :");
			String Nom = scanner.next();
			player = new Human(Nom,scanner);
		}
		else if(NomTypeJoueur.equalsIgnoreCase("Negamax"))
			player = new NegamaxPlayer();
		else{
			Random rand = new Random(123);
			player = new RandomPlayer(rand);
		}
		return player;
	}
	
	private static Game gameType(Scanner scanner,Player p1,Player p2,String Nomjeu){
		Game game;
		if(Nomjeu.equalsIgnoreCase("Nim")){
			System.out.println("Le nombre d'allumettes de départ est :(attention pas de letres, que des nombres!");
			int n =Integer.parseInt(scanner.next());
			System.out.println("Le nombre d'allumettes retirables est :");
			int k =Integer.parseInt(scanner.next());
			game = new Nim(n,k,p1, p2);
		}
		else
			game = new TicTacToe(p1, p2);
		return game;
	}

	public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Les types de joueurs disponibles sont:");
	System.out.println("-Human(joueur humain)");
	System.out.println("-Negamax(IA Negamax)");
	System.out.println("-Random(IA Aléatoire))");
	System.out.println("Quel est le type du joueur 1?");
	Player p1 = playertype(scanner,scanner.next());
	System.out.println("Quel est le type du joueur 2?");
	Player p2 = playertype(scanner,scanner.next());
	System.out.println("Les types de jeux disponibles sont:");
	System.out.println("-Nim");
	System.out.println("-TicTacToe");
	System.out.println("Quel est le type du jeu?");
	Game game = gameType(scanner,p1,p2,scanner.next());
 
 	Orchestrator orchestrator = new Orchestrator(game);
	orchestrator.play();
	scanner.close();
	
	}
}



/*
	pour 2 joueurs random

Random rand1 = new Random(123);
Random rand2 = new Random(321);
Player player1 = new RandomPlayer(rand1);
Player player2 = new RandomPlayer(rand2);

	pour 2 joueurs Humain
	
 Scanner scanner=new Scanner(System.in);
 
 
Player player1 = new Human("Moi",scanner);
Player player2 = new Human("Toi",scanner);
 
 	pour nim 20 allumettes 3 retirables max
 	
  Nim game = new Nim(20,3,player1, player2);
 
 	pour TicTacToe
 	
 TicTacToe game = new TicTacToe(player1, player2);
 
 NegamaxPlayer
 

*/
