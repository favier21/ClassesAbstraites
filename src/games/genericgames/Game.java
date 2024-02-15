package games.genericgames; 
import games.players.Player;
import java.util.ArrayList;

public interface Game {

 public Player getCurrentPlayer();


 public boolean isValid(int coup);


 public ArrayList<Integer> validMoves();


 public void execute(int a);

 public boolean isOver();

 public Player getWinner();


 public String moveToString(int move);


 public String situationToString();

 public Game copy();

}
