package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import modele.Modele;
import modele.scnObjects.Scenario;
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
		
		//Chargement des scnObjects:
		//scriptReader.loadObjects();  //<- A REMPLACER
		
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
		//Recuperation des données du fichier XML:
		Scenario scenarioLoaded = xmlTool.getScenarioParameterFile("scenario.xml");
		
		//Ajout des données récupérées au modèle:
		model.addScenario(scenarioLoaded);
		
		//Injection des données récupérées dans le script:
		scriptReader.injectScenarioIntoScript(scenarioLoaded);
	}

	public void actionPerformed(ActionEvent evt) 
	{
//		System.out.println("DA");
//		if (evt.getSource().getClass().equals(JButton.class))
//		{
//			System.out.println("FROM BUTTON");
//			JButton da = (JButton) evt.getSource();
//			if ( da.getText().equals("Launch Scenario"))
//			{
//				System.out.println("LAUCHN SCENARIO");
//			}
//		}
	}
	
	
	
//	
//	 public class Controller {
//	     Model m;
//	     public ActionListener getDeleteListener () {
//	         return new ActionListener() {
//	             @Override public void actionPerformed (ActionEvent e) {
//	                 m.deleteSomething();
//	             }
//	         };
//	     }
//	 }
//	 
//	 public class GUI extends JFrame {
//	     JButton deleteButton; 
//	     public GUI (View v, Controller c) {
//	         deleteButton.addActionListener(c.getDeleteListener()); 
//	     }
//	 }
}
