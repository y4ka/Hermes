package modele.tools;

import java.util.Scanner;

public class KeyPressThread implements Runnable 
{
    private Scanner inputReader = new Scanner(System.in);

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
                    
                }
                else if(input.equals("stop"))
                {
                    
                }
                else if(input.equalsIgnoreCase("exit"))
                {
                    break; // stop KeyPressThread
                }
            }
        }
    }

}

