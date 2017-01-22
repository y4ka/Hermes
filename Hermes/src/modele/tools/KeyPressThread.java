package modele.tools;

import java.util.Scanner;

import controler.MainController;

public class KeyPressThread extends Thread
{
    private Scanner inputReader = new Scanner(System.in);
    private MainController controller;

    public KeyPressThread() 
    {
    	
    }

    public void run() 
    {
        while(true) 
        {
            if (inputReader.hasNext())
            {
                String input = inputReader.next();
                System.out.println("CONSOLE INPUT: "+input);
                
                if(input.equals("start"))
                {
                	controller.launchTimer();
                }
                else if(input.equals("stop"))
                {
                	controller.stopTimer();
                }
                else if(input.equalsIgnoreCase("exit"))
                {
                    break; // stop KeyPressThread
                }
            }
        }
    }
    
    public void addContoller(MainController controller)
    {
    	this.controller = controller;
    }

}

