package controler;


public class MainController 
{
	private ScriptReader scriptReader =  new ScriptReader();
	
	public MainController()
	{
		this.initialisation();
		
		System.out.println("===============================================================================================");
		
		//TEST SCENARIO:
		scriptReader.invokeButtonInput(0, "BLUE");
	}
	
	private void initialisation()
	{
		scriptReader.init();
		scriptReader.loadObjects();
	}
	
	public void messageReceived()
	{
		scriptReader.invokeScriptIntelligence();
	}
}
