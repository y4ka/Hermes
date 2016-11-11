package main;

import messageAdapter.MessageAdapter;
import modele.Modele;
import vue.View;
import controler.MainController;

public class MainClass 
{
	public static void main (String [] args) throws NoSuchMethodException
	{		
		//Create Model and View:
		Modele model = new Modele();
		View view = new View();
		
		//Tell Model about View. 
		model.addObserver(view);
		
		//Create Controller. tell it about Model and View, initialise model
		MainController controller = new MainController();
		controller.addModel(model);
		controller.addView(view);
		
		//Lancement sans IHM:
		//controller.initScenario("scenario.js");
		//controller.initModel("scenario.xml");
		//controller.launch();

		//Tell View about Controller 
		view.addController(controller);
		
		//Create Message Adapter
		MessageAdapter messageAdapter = new MessageAdapter(controller);
	}
}
