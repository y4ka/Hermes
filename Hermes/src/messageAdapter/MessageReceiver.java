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
		System.out.println("MessageReceiver: INPUT BUTTON (idPylon = "+idPylon+" , idButton = "+idButton+")");
		controller.messageReceived();
	}
}
