package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import modele.Modele;
import modele.tools.XmlTool;
import vue.View;


public class MainController implements ActionListener 
{
	
	private Modele model;
	private View view;
	
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
	
	public void addModel(Modele m)
	{
		this.model = m;
	}

	public void addView(View v)
	{
		this.view = v;
	}

	public void initModel()
	{
		
	}

	public void actionPerformed(ActionEvent evt) 
	{
		
	}
}
