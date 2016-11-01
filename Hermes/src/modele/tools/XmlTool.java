package modele.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modele.scnObjects.Player;
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
		
		Scenario loadedScenario = new Scenario(2, 2, 2);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try 
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("scenario.xml"));
			Element racine = document.getDocumentElement();
			
			//TEAMS:
			NodeList listeTeams = racine.getElementsByTagName("team");
			for (int i = 0 ; i < listeTeams.getLength() ; i++) 
			{
				Element team = (Element) listeTeams.item(i);
				NodeList teamShortName = team.getElementsByTagName("teamShortName");
				NodeList teamName = team.getElementsByTagName("teamName");
				
				int scnTeamId = Integer.parseInt(team.getAttribute("teamId"));
				String scnTeamShortName = teamShortName.item(0).getTextContent();
				String scnTeamName = teamName.item(0).getTextContent();
				
				System.out.println("-> Team "+scnTeamId);
				System.out.println(" -> "+scnTeamShortName);
				System.out.println(" -> "+scnTeamName);
				
				Team scnTeam = new Team(scnTeamId, scnTeamName, scnTeamShortName);
				loadedScenario.addTeam(scnTeam);
			}
			
			//PLAYERS:
			NodeList listePlayers = racine.getElementsByTagName("player");
			for (int i = 0 ; i < listePlayers.getLength() ; i++) 
			{
				Element player = (Element) listePlayers.item(i);
				NodeList playerName = player.getElementsByTagName("playerName");
				
				int scnPlayerId = Integer.parseInt(player.getAttribute("playerId"));
				String scnPlayerName = playerName.item(0).getTextContent();
				
				System.out.println("-> Player "+scnPlayerId);
				System.out.println(" -> "+scnPlayerName);
				
				Player scnPlayer = new Player(scnPlayerId, scnPlayerName);
				loadedScenario.addPlayer(scnPlayer);
			}
			
			
			//PYLONS:
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
