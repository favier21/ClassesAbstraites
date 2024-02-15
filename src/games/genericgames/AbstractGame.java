package games.genericgames;
import games.players.Player;
public abstract class AbstractGame implements Game{

	Player j1;

	Player j2;

	Player joueurActuel;

	public AbstractGame(Player j1, Player j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.joueurActuel = this.j1;

	}

	public Player getCurrentPlayer() {
		//renvoie le joueur actuel
		return this.joueurActuel;

	}
	

	protected abstract void doExecute(int a);
	
	public void execute(int a){
		this.doExecute(a);

		if(this.getCurrentPlayer()==this.j1){
			this.joueurActuel = this.j2;
		}
		else{
			this.joueurActuel = this.j1;
		}
	}




}
