package vue;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer
{
	public View()
	{
		//MainFrame frame = new MainFrame(mainController);
	}
	
	//Called from the Model
	public void update(Observable obs, Object obj) 
	{
		
	}
	
	public void addController(ActionListener controller)
	{
		//button.addActionListener(controller);
	}
}
