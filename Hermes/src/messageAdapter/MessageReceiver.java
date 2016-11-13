package messageAdapter;

import controler.MainController;

public class MessageReceiver 
{
	private MainController controller;
	
	public MessageReceiver(MainController controller)
	{
		this.controller = controller;
	}
	
	public void inputButton(int idPylon, int idButton)
	{
		controller.messageReceived();
	}
}
