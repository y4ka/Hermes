package messageAdapter;

import java.net.*;
import java.io.*;

import modele.tools.ViewLogger.Logger;

public class TCPServer extends Thread
{

	final static int port = 9632;
	private Socket socket;

	public TCPServer(Socket socket)
	{
		this.socket = socket;
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

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			messageClient = inFromClient.readLine();
			
			Logger.instance.logReceiver(messageClient);
			
			DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
			String ack = "ACK";
			outToClient.writeBytes("ACK");
			Logger.instance.logSender(ack);

			socket.close();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
