package vue;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import controler.MainController;

public class View implements Observer
{
	ScnControlFrame scnControlFrame;
	LaunchFrame launchFrame;
	
	public View()
	{
		scnControlFrame = new ScnControlFrame();
		launchFrame = new LaunchFrame();
	}
	
	//Called from the Model
	public void update(Observable obs, Object obj) 
	{
		scnControlFrame.update(obs, obj);
	}
	
	public void addController(MainController controller)
	{
		scnControlFrame.addController(controller);
		launchFrame.addController(controller);
	}
}
