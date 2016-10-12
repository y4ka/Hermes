package modele.tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileTool 
{	
	public FileTool() 
	{
		
	}
	
	public String readFile(String filePath)
	{
		String result = "";
		try 
		{
			InputStream ips = new FileInputStream(filePath);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) 
			{
				System.out.println(ligne);
				result += ligne + "\n";
			}
			br.close();
			
		} catch (Exception e) 
		{
			System.out.println(e.toString());
		}
		
		return result;
	}
}
