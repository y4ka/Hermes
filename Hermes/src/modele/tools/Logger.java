package modele.tools;

import java.awt.Color;
import java.util.Date;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Logger 
{
	public Logger()
	{
		
	}
	
	public static void insertString(String log, String priority, JTextPane jtextPane)
	{
		StyledDocument doc = jtextPane.getStyledDocument();
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		
		if (priority.equals("ERROR"))
		{
			StyleConstants.setForeground(keyWord, Color.RED);
			StyleConstants.setBold(keyWord, true);
		}
		else if (priority.equals("INFO"))
		{
			StyleConstants.setForeground(keyWord, Color.BLACK);
			StyleConstants.setBold(keyWord, false);
		}
		else if (priority.equals("TRACE"))
		{
			StyleConstants.setForeground(keyWord, Color.BLACK);
			StyleConstants.setBold(keyWord, false);
		}
		
		try 
		{
			doc.insertString(doc.getLength(), log+"\n", keyWord);
		} 
		catch (BadLocationException e) 
		{
			e.printStackTrace();
		}
	}
}
