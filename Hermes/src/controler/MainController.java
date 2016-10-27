package controler;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modele.tools.XmlTool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MainController 
{
	private ScriptReader scriptReader =  new ScriptReader();
	private XmlTool xmlTool = new XmlTool();
	private TimerTask task;
	private Timer timer = new Timer();
	private int nbTick = 0;
	
	public MainController()
	{
		this.initialisation();
		//this.launch();
		
		//TEST SCENARIO:
		//scriptReader.invokeButtonInput(0, "BLUE");
	}
	
	public void initialisation()
	{
		//Initialisation du ScriptReader:
		scriptReader.init();
		
		//Recuperation des données du fichier XML:
		xmlTool.getScenarioParameterFile("scenario.xml");
		
		//Chargement des scnObjects:
		scriptReader.loadObjects();
		
		//Creation du Timer:
		task = new TimerTask()
		{
			@Override
			public void run() 
			{
				scriptReader.invokeTick(nbTick);
				nbTick++;
			}	
		};
	}
	
	public void launch()
	{
		//Lancement du Timer:
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public void messageReceived()
	{
		
	}
}
