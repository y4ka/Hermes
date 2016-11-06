package vue;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer
{
	ScnControlFrame scnControlFrame;
	
	public View()
	{
		scnControlFrame = new ScnControlFrame();
	}
	
	//Called from the Model
	public void update(Observable obs, Object obj) 
	{
		scnControlFrame.update(obs, obj);
	}
	
	public void addController(ActionListener controller)
	{
		scnControlFrame.addController(controller);
		//button.addActionListener(controller);
	}
}
