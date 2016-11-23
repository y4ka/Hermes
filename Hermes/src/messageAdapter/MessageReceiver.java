package messageAdapter;

import modele.tools.ViewLogger.Logger;
import controler.MainController;

public class MessageReceiver 
{
	private MainController controller;
	
	public MessageReceiver(MainController controller)
	{
		this.controller = controller;
	}
	
	public void messageReceived()
	{
		
	}
	
	public void inputButton(int idPylon, String colorButton)
	{
		controller.getScriptReader().invokeButtonInput(idPylon, colorButton);
		Logger.instance.logReceiver("INPUT BUTTON: "+idPylon+", "+colorButton);
	}
	
	public void keyboardInput(int idPylon, String keyboardString)
	{
		controller.getScriptReader().invokeKeyboardInput(idPylon, keyboardString);
		Logger.instance.logReceiver("INPUT KEYBOARD: "+idPylon+", "+keyboardString);
	}
	
	public void targetInput(int idPylon)
	{
		controller.getScriptReader().invokeTargetInput(idPylon);
		Logger.instance.logReceiver("INPUT TARGET: "+idPylon);
	}
	
	public void batteryVoltage(int idPylon, int value)
	{
		
	}
	
	public void duskLevel(int idPylon, int value)
	{
		
	}
	
	public void radioLinkQuality(int idPylon, int value)
	{
		
	}
	
	public void wifiLinkQuality(int idPylon, int value)
	{
		
	}
}
