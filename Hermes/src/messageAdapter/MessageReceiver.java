package messageAdapter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import modele.tools.ViewLogger.Logger;
import controler.MainController;

public class MessageReceiver 
{
	private MainController controller;
	
	private int port = 9632;
	private int taille = 1024;
	
	public MessageReceiver(MainController controller)
	{
		this.controller = controller;
	}
	
	public void launchServer()
	{
		try 
		{
			this.messageListener();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void messageListener() throws IOException
	{
		byte buffer[] = new byte[taille];
		DatagramSocket socket = new DatagramSocket(port);
	    String donnees = "";
	    String messageRetour = "";
	    int taille = 0;
	    
		Logger.instance.logReceiver("LAUNCHING UDP SERVER");
	    
		while (true) 
	    {
	      DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
	      DatagramPacket envoi = null;
	      socket.receive(paquet);
	      
	      taille = paquet.getLength();
	      donnees = new String(paquet.getData(),0, taille);
	      
	      //On envoie le message reçu aux methodes pour le traiter:
	      this.messageDecryption(donnees);
	      
	      Logger.instance.logReceiver(donnees);
	      
	      messageRetour = "ACK: "+donnees;
	      envoi = new DatagramPacket(messageRetour.getBytes(), messageRetour.length(), paquet.getAddress(), paquet.getPort());
	      socket.send(envoi);
	    }
	}
	
//	   =================================================
//	   ===== ===== DECRYPTAGE DES TRAMES UDP ===== =====
//	   =================================================
	
	private void messageDecryption(String donnee)
	{
		String[] parametres = donnee.split("/");
		
		if(parametres.length != 0)
		{	
			int idPylon = Integer.parseInt(parametres[1]);
			
			switch (parametres[0]) 
			{
				case "BUTTON":
					String colorButton = parametres[2];
					this.inputButton(idPylon, colorButton);
				break;
				case "TARGET":
					this.targetInput(idPylon);
				break;
				case "KEYBOARD":
					String keyboardString = parametres[2];
					this.keyboardInput(idPylon, keyboardString);
				break;
			}
		}
	}
	
//	   ==========================================
//	   ===== ===== APPEL DES METHODES ===== =====
//	   ==========================================
	
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
		Logger.instance.logReceiver("BATTERY VOLTAGE: "+idPylon+", "+value);
	}
	
	public void duskLevel(int idPylon, int value)
	{
		Logger.instance.logReceiver("DUSK LEVEL: "+idPylon+", "+value);
	}
	
	public void radioLinkQuality(int idPylon, int value)
	{
		Logger.instance.logReceiver("RADIO LINK QUALITY: "+idPylon+", "+value);
	}
	
	public void wifiLinkQuality(int idPylon, int value)
	{
		Logger.instance.logReceiver("WIFI LINK QUALITY: "+idPylon+", "+value);
	}
}
