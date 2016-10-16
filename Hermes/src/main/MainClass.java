package main;

import messageAdapter.MessageAdapter;
import modele.Modele;
import vue.MainFrame;
import controler.MainController;

public class MainClass 
{
	public static void main (String [] args) throws NoSuchMethodException
	{
		MainController mainController = new MainController();
		MessageAdapter messageAdapter = new MessageAdapter(mainController);
		Modele modele = new Modele();
		MainFrame frame = new MainFrame(mainController);
	}
}
