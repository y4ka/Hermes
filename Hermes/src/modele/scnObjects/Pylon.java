package modele.scnObjects;

public class Pylon
{
	private int id;
	private String name;
	private int nbOwners;
	private Team[] owners;
	
	public Pylon(int id, String name, boolean pylonEnabled)
	{
		this.id = id;
		this.name = name;
		this.nbOwners = 0;
		this.owners = new Team[1];
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

	public int getNbOwners() {
		return nbOwners;
	}

	public void setNbOwners(int nbOwners) {
		this.nbOwners = nbOwners;
	}

	public Team[] getOwners() {
		return owners;
	}

	public void setOwners(Team[] owner) {
		this.owners = owner;
	}
	
	//Provisioire
	public void addTeam(Team team)
	{
		owners[0] = team;
	}
}
