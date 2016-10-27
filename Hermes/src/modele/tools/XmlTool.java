package modele.tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modele.scnObjects.Scenario;

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
			NodeList listeTeams = racine.getElementsByTagName("team");
			
			for (int i = 0 ; i < listeTeams.getLength() ; i++) 
			{
				Element team = (Element) listeTeams.item(i);
				System.out.println("-> Team "+team.getAttribute("teamId"));
				NodeList teamShortName = team.getElementsByTagName("teamShortName");
				NodeList teamName = team.getElementsByTagName("teamName");
				System.out.println(" -> "+teamShortName.item(0).getTextContent());
				System.out.println(" -> "+teamName.item(0).getTextContent());
			}
			
			NodeList listePlayers = racine.getElementsByTagName("player");
			for (int i = 0 ; i < listePlayers.getLength() ; i++) 
			{
				Element player = (Element) listePlayers.item(i);
				System.out.println("-> Player "+player.getAttribute("idPlayer"));
				NodeList playerName = player.getElementsByTagName("playerName");
				System.out.println(" -> "+playerName.item(0).getTextContent());
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
