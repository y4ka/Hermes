package modele.tools;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public interface ViewLogger 
{
	void log(String log);

	enum Logger 
	{
		instance;

		private List<JTextPane> listeners = new LinkedList<JTextPane>();

		public void addListener(JTextPane statusTextPane)
		{
			synchronized (listeners) 
			{
				listeners.add(statusTextPane);
			}
		}

		public void log(String log) 
		{
			synchronized (listeners) 
			{
				//Sortie des logs dans la vue:
				for (JTextPane jtextPane : listeners)
				{
					StyledDocument doc = jtextPane.getStyledDocument();
					SimpleAttributeSet keyWord = new SimpleAttributeSet();
					
					try 
					{
						doc.insertString(doc.getLength(), log+"\n", keyWord);
					} 
					catch (BadLocationException e) 
					{
						e.printStackTrace();
					}
				}
				
				//Sortie des logs en console:
				System.out.println(log);
			}
		}
		
		public void log(String log, EnumLogger.Log level)
		{
			synchronized (listeners) 
			{
				//Sortie des logs dans la vue:
				for (JTextPane jtextPane : listeners)
				{
					StyledDocument doc = jtextPane.getStyledDocument();
					SimpleAttributeSet keyWord = new SimpleAttributeSet();
					
					try 
					{
						doc.insertString(doc.getLength(), log+"\n", keyWord);
					} 
					catch (BadLocationException e) 
					{
						e.printStackTrace();
					}
				}
				
				//Sortie des logs en console:
				System.out.println(log);
			}
		}
	}
}
