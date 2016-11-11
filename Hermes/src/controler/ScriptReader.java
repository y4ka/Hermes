package controler;

import java.io.File;
import java.util.List;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import modele.scnObjects.Player;
import modele.scnObjects.Pylon;
import modele.scnObjects.Scenario;
import modele.scnObjects.Team;
import modele.tools.FileTool;

public class ScriptReader 
{
	private ScriptEngine moteur;
	private String scriptString;
	
	public ScriptReader()
	{
		
	}
	
	public void invokeButtonInput(int idButton, String colorButton)
	{
		try 
		{
			//moteur.eval(scriptString);

			// On recupere les valeurs en sortie:
			// Integer resultat = (Integer)moteur.get("newID");
			// System.out.println("resultat = "+resultat);

			// On teste la reception d'un message d'un pylone:
			if (moteur instanceof Invocable) 
			{
				Invocable moteurInvocable = (Invocable) moteur;
				Object result = moteurInvocable.invokeFunction("inputButton", idButton, colorButton);
				System.out.println("resultat = " + result);
			} 
			else 
			{
				System.err.println("Le moteur n'implemente pas l'interface Invocable");
			}

		} catch (ScriptException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public void invokeTick(int nbTick)
	{
		try 
		{
			if (moteur instanceof Invocable) 
			{
				Invocable moteurInvocable = (Invocable) moteur;
				Object result = moteurInvocable.invokeFunction("tick", nbTick);
				System.out.println("Tick = " + result);
			}
			else 
			{
				System.err.println("Le moteur n'implemente pas l'interface Invocable");
			}

		} catch (ScriptException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public boolean injectScenarioIntoScript(Scenario scenario)
	{
		if (moteur != null)
		{
			moteur.put("scenario", scenario);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void loadEngine()
	{
		System.out.println("\n***** LOAD SCIPT ENGINE *****");
		
		ScriptEngineManager manager = new ScriptEngineManager();
		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		
		for (ScriptEngineFactory factory : factories) 
		{
			System.out.println("Name : " + factory.getEngineName());
			System.out.println("Version : " + factory.getEngineVersion());
			System.out.println("Language name : " + factory.getLanguageName());
			System.out.println("Language version : " + factory.getLanguageVersion());
			System.out.println("Extensions : " + factory.getExtensions());
			System.out.println("Mime types : " + factory.getMimeTypes());
			System.out.println("Names : " + factory.getNames());
		}
		
		//CHARGEMENT DU SCRIPT ENGINE:
		String engineName = "javascript";
		this.moteur = manager.getEngineByName(engineName);
		if (moteur == null) 
		{ 
	        System.out.println("Impossible de trouver le moteur "+engineName+"."); 
	    }
		else
		{
			System.out.println("Moteur "+engineName+" charg�.");
		}
	}
	
	public void loadScript(String scenarioFileName)
	{
		System.out.println("\n***** LOAD SCRIPT FILE *****");
		
		//CHARGEMENT DU SCRIPT:
		FileTool fileTool = new FileTool();
		this.scriptString = fileTool.readFile(scenarioFileName);
		
		//EVALUATION DU SCRIPT:
		try 
		{
			moteur.eval(scriptString);
		} 
		catch (ScriptException e) 
		{
			e.printStackTrace();
		}
	}
}
