package controler;

import java.io.File;


public class MainController 
{
	private ScriptReader scriptReader =  new ScriptReader();
	
	public MainController()
	{
		this.initialisation();
		
		//TEST SCENARIO:
		scriptReader.invokeButtonInput(0, "BLUE");
	}
	
	public void initialisation()
	{
		scriptReader.init();
		scriptReader.loadObjects();
	}
	
	
	
	public void messageReceived()
	{
		scriptReader.invokeScriptIntelligence();
	}
}
