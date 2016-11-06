package modele.scnObjects;

import java.util.ArrayList;

public class Team 
{
	private int id;
	private String name;
	private String shortName;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Team(int id, String name, String shortName)
	{
		this.id = id;
		this.name = name;
		this.shortName = shortName;
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
		return players.size();
	}
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player)
	{
		players.add(player);
	}
}
