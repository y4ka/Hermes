package main;

import messageAdapter.MessageAdapter;
import vue.MainFrame;
import controler.MainController;

public class MainClass 
{
	public static void main (String [] args) throws NoSuchMethodException
	{
		MainController mainController = new MainController();
		MessageAdapter messageAdapter = new MessageAdapter(mainController);
		MainFrame frame = new MainFrame(mainController);
	}
}
