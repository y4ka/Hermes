package modele.scnObjects;

public class Team 
{
	private int id;
	private String name;
	private int nbPlayers;
	private Player[] players;
	
	public Team(int id, String name)
	{
		this.id = id;
		this.name = name;
		this.nbPlayers = 1;
		this.players = new Player[nbPlayers];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbPlayers() {
		return nbPlayers;
	}

	public void setNbPlayers(int nbPlayers) {
		this.nbPlayers = nbPlayers;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	//Provisioire
	public void addPlayers(Player player)
	{
		players[0] = player;
	}
}
