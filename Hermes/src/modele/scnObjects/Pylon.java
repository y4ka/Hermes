package modele.scnObjects;

import java.util.ArrayList;

public class Pylon
{
	private int id;
	private String name;
	private boolean enabled;
	private boolean hitDetectorEnabled;
	private boolean keyboardEnabled;
	private ArrayList<Team> owners = new ArrayList<Team>();
	
	private int tensionBatterie;
	private int niveauCrepuscule;
	private int qualiteLiaisonRadio;
	private int qualiteLiaisonWifi;
	
	public Pylon(int id, String name, boolean enabled, boolean hitDetectorEnabled, boolean keyboardEnabled)
	{
		this.id = id;
		this.name = name;
		this.enabled = enabled;
		this.hitDetectorEnabled = hitDetectorEnabled;
		this.keyboardEnabled = keyboardEnabled;
		
		this.tensionBatterie = 10;
		this.niveauCrepuscule = 100;
		this.qualiteLiaisonRadio = 100;
		this.qualiteLiaisonWifi = 100;
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
	
	public boolean isHitDetectorEnabled() {
		return hitDetectorEnabled;
	}

	public void setHitDetectorEnabled(boolean hitDetectorEnabled) {
		this.hitDetectorEnabled = hitDetectorEnabled;
	}

	public boolean isKeyboardEnabled() {
		return keyboardEnabled;
	}

	public void setKeyboardEnabled(boolean keyboardEnabled) {
		this.keyboardEnabled = keyboardEnabled;
	}

	public void addOwner(Team team)
	{
		owners.add(team);
	}

	public int getTensionBatterie() {
		return tensionBatterie;
	}

	public void setTensionBatterie(int tensionBatterie) {
		this.tensionBatterie = tensionBatterie;
	}

	public int getNiveauCrepuscule() {
		return niveauCrepuscule;
	}

	public void setNiveauCrepuscule(int niveauCrepuscule) {
		this.niveauCrepuscule = niveauCrepuscule;
	}

	public int getQualiteLiaisonRadio() {
		return qualiteLiaisonRadio;
	}

	public void setQualiteLiaisonRadio(int qualiteLiaisonRadio) {
		this.qualiteLiaisonRadio = qualiteLiaisonRadio;
	}

	public int getQualiteLiaisonWifi() {
		return qualiteLiaisonWifi;
	}

	public void setQualiteLiaisonWifi(int qualiteLiaisonWifi) {
		this.qualiteLiaisonWifi = qualiteLiaisonWifi;
	}
}
