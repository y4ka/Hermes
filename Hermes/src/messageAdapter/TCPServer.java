package messageAdapter;

import java.net.*;
import java.io.*;

import modele.tools.ViewLogger.Logger;

public class TCPServer extends Thread
{

	final static int port = 9632;
	private Socket socket;
	private MessageAdapter messageAdapter;
	

	public TCPServer(Socket socket, MessageAdapter messageAdapter)
	{
		this.socket = socket;
		this.messageAdapter = messageAdapter;
	}

	public void run()
	{
		traitements();
	}

	public void traitements()
	{	
		try
		{
			String messageClient = "";

			Logger.instance.logReceiver("Connection with client: "+socket.getInetAddress());

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			messageClient = in.readLine();
			Logger.instance.logReceiver(messageClient);
			
			this.send("ACK");

//			socket.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void send(String message)
	{		
		try
		{
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println(message);
			Logger.instance.logSender(message);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		
		try
		{
			//On ferme la connexion TCP:
			socket.close();
			Logger.instance.logSender("Connexion closed with client "+socket.getInetAddress());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
