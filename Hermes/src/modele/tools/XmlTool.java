package modele.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modele.scnObjects.Player;
import modele.scnObjects.Pylon;
import modele.scnObjects.Scenario;
import modele.scnObjects.Team;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlTool 
{
	public XmlTool()
	{
		
	}
	
	public Scenario getScenarioParameterFile(String xmlFile)
	{
		System.out.println("\n***** LOAD XML FILES *****");
		
		Scenario loadedScenario = null;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try 
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(xmlFile));
			Element racine = document.getDocumentElement();
			
			//On recupere le nombre de Teams, de Players et de Pylons:
			NodeList nodeListTeams = racine.getElementsByTagName("teams");
			NodeList nodeListPlayers = racine.getElementsByTagName("players");
			NodeList nodeListPylons = racine.getElementsByTagName("pylons");
			Element teams = (Element) nodeListTeams.item(0);
			Element players = (Element) nodeListPlayers.item(0);
			Element pylons = (Element) nodeListPylons.item(0);
			
			int nbTeams = Integer.parseInt(teams.getAttribute("nbTeams"));
			int nbPlayers = Integer.parseInt(players.getAttribute("nbPlayers"));
			int nbPylons = Integer.parseInt(pylons.getAttribute("nbPylons"));
			
			System.out.println("nbTeams: "+teams.getAttribute("nbTeams"));
			System.out.println("nbPlayers: "+players.getAttribute("nbPlayers"));
			System.out.println("nbPylons: "+pylons.getAttribute("nbPylons"));
			
			//On crée notre objet scenario:
			loadedScenario = new Scenario(nbPylons, nbPlayers, nbTeams);
			
			//PARSE TEAMS:
			NodeList listeTeams = racine.getElementsByTagName("team");
			for (int i = 0 ; i < listeTeams.getLength() ; i++)
			{
				Element team = (Element) listeTeams.item(i);
				NodeList teamShortName = team.getElementsByTagName("teamShortName");
				NodeList teamName = team.getElementsByTagName("teamName");
				NodeList spawnAllowed = team.getElementsByTagName("spawnAllowed");
				NodeList spawnNumber = team.getElementsByTagName("spawnNumber");
				
				int scnTeamId = Integer.parseInt(team.getAttribute("teamId"));
				String scnTeamShortName = teamShortName.item(0).getTextContent();
				String scnTeamName = teamName.item(0).getTextContent();
				boolean scnSpawnAllowed = Boolean.parseBoolean(spawnAllowed.item(0).getTextContent());
				int scnSpawnNumber = Integer.parseInt(spawnNumber.item(0).getTextContent());
				
				System.out.println("-> Team "+scnTeamId);
				System.out.println(" -> "+scnTeamShortName);
				System.out.println(" -> "+scnTeamName);
				System.out.println(" -> "+scnSpawnAllowed);
				System.out.println(" -> "+scnSpawnNumber);
				
				
				Team scnTeam = new Team(scnTeamId, scnTeamName, scnTeamShortName, scnSpawnAllowed, scnSpawnNumber);
				loadedScenario.addTeam(scnTeam);
			}
			
			//PARSE PLAYERS:
			NodeList listePlayers = racine.getElementsByTagName("player");
			for (int i = 0 ; i < listePlayers.getLength() ; i++) 
			{
				Element player = (Element) listePlayers.item(i);
				NodeList playerName = player.getElementsByTagName("playerName");
				NodeList teamId = player.getElementsByTagName("teamId");
				
				int scnPlayerId = Integer.parseInt(player.getAttribute("playerId"));
				String scnPlayerName = playerName.item(0).getTextContent();
				int scnTeamId = Integer.parseInt(teamId.item(0).getTextContent());
				
				System.out.println("-> Player "+scnPlayerId);
				System.out.println(" -> "+scnPlayerName);
				System.out.println(" -> "+scnTeamId);
				
				Player scnPlayer = new Player(scnPlayerId, scnPlayerName);
				loadedScenario.addPlayer(scnPlayer);
				loadedScenario.getTeams()[scnTeamId].addPlayer(scnPlayer);
			}
			
			
			//PARSE PYLONS:
			NodeList listePylons = racine.getElementsByTagName("pylon");
			for (int i = 0 ; i < listePylons.getLength() ; i++) 
			{
				Element pylon = (Element) listePylons.item(i);
				NodeList pylonName = pylon.getElementsByTagName("pylonName");
				NodeList enabled = pylon.getElementsByTagName("enabled");
				
				int scnPylonId = Integer.parseInt(pylon.getAttribute("pylonId"));
				String scnPylonName = pylonName.item(0).getTextContent();
				boolean scnEnabled = Boolean.parseBoolean(enabled.item(0).getTextContent());
				
				System.out.println("-> Pylon "+scnPylonId);
				System.out.println(" -> "+scnPylonName);
				System.out.println(" -> "+scnEnabled);
				
				Pylon scnPylon = new Pylon(scnPylonId, scnPylonName, scnEnabled);
				loadedScenario.addPylon(scnPylon);
			}
			
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		return loadedScenario;
	}
}
