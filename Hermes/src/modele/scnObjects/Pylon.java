package modele.scnObjects;

import java.util.ArrayList;

public class Pylon
{
	private int id;
	private String name;
	private boolean enabled;
	private ArrayList<Team> owners = new ArrayList<Team>();
	
	public Pylon(int id, String name, boolean enabled)
	{
		this.id = id;
		this.name = name;
		this.enabled = enabled;
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
		return owners.size();
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ArrayList<Team> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Team> owners) {
		this.owners = owners;
	}

	public void addOwner(Team team)
	{
		owners.add(team);
	}
}
