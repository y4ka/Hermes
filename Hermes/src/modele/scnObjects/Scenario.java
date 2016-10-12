package modele.scnObjects;

import java.util.ArrayList;
import java.util.Hashtable;

public class Scenario 
{
	private int numberOfPylons;
	private int numberOfPlayers;
	private int numberOfTeams;
	
	private Pylon[] pylons;
	private Player[] players;
	private Team[] teams;
	
	private Hashtable<Integer, Player> da = new Hashtable<Integer, Player>();
	
	
	public Scenario(int numberOfPylons, int numberOfPlayers, int numberOfTeams)
	{
		this.numberOfPylons = numberOfPylons;
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfTeams = numberOfTeams;
		
		this.pylons = new Pylon[numberOfPylons];
		this.players = new Player[numberOfPlayers];
		this.teams = new Team[numberOfTeams];
	}

	
	
	public int getNumberOfPylons() {
		return numberOfPylons;
	}



	public void setNumberOfPylons(int numberOfPylons) {
		this.numberOfPylons = numberOfPylons;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}



	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}



	public int getNumberOfTeams() {
		return numberOfTeams;
	}



	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}



	public Pylon[] getPylons() {
		return pylons;
	}



	public void setPylons(Pylon[] pylons) {
		this.pylons = pylons;
	}



	public Player[] getPlayers() {
		return players;
	}



	public void setPlayers(Player[] players) {
		this.players = players;
	}



	public Team[] getTeams() {
		return teams;
	}



	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	

	//Provisioire
	public void addPylon(Pylon pylon)
	{
		pylons[0] = pylon;
	}
	
	public void addPlayer(Player player)
	{
		players[0] = player;
	}
	
	public void addTeam(Team team)
	{
		teams[0] = team;
	}
	
	public void addTest(Player newPlayer)
	{
		da.put(newPlayer.getId(), newPlayer);
	}



	public Hashtable<Integer, Player> getDa() {
		return da;
	}



	public void setDa(Hashtable<Integer, Player> da) {
		this.da = da;
	}

	
}
