package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controler.MainController;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import modele.scnObjects.Scenario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class InputFrame extends JFrame {

	private JPanel contentPane;
	
	private MainController controller;
	private JPanel mainPanel;

	/**
	 * Create the frame.
	 */
	public InputFrame() 
	{
		setTitle("InputFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(1, 0, 0, 0));
		setVisible(true);
	}
	
	public void addController(MainController controller)
	{
		this.controller = controller;
	}
	
	public void update(Observable obs, Object obj) 
	{
		Scenario scenario = (Scenario) obj;
		
		//Remove all previous components (update)
		mainPanel.removeAll();
		
		//Affichage Dynamique des Pylons:
		for (int i = 0 ; i < scenario.getNumberOfPylons() ; i++)
		{
			int pylonId = scenario.getPylons()[i].getId();
			String pylonName = scenario.getPylons()[i].getName();
			int nbOwners = scenario.getPylons()[i].getNbOwners();
			
			JPanel panelPylons = new JPanel();
			panelPylons.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pylon no "+pylonId, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPylons.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel labelPlayerName = new JLabel("<html><u>Name:</u> "+pylonName+"</html>");
			JLabel labelNbOwners = new JLabel("<html><u>Nb Owners:</u> "+nbOwners+"</html>");
			JButton buttonRed = new JButton("Red");
			JButton buttonBlue = new JButton("Blue");
			JButton buttonBlack = new JButton("Black");
			JButton buttonYellow = new JButton("Yellow");
			JButton buttonGreen = new JButton("Green");
			
			buttonRed.addActionListener(createDynamicActionListeners(pylonId, "RED"));
			buttonBlue.addActionListener(createDynamicActionListeners(pylonId, "BLUE"));
			buttonBlack.addActionListener(createDynamicActionListeners(pylonId, "BLACK"));
			buttonYellow.addActionListener(createDynamicActionListeners(pylonId, "YELLOW"));
			buttonGreen.addActionListener(createDynamicActionListeners(pylonId, "GREEN"));
			
			panelPylons.add(labelPlayerName);
			panelPylons.add(labelNbOwners);
			panelPylons.add(buttonRed);
			panelPylons.add(buttonBlue);
			panelPylons.add(buttonBlack);
			panelPylons.add(buttonYellow);
			panelPylons.add(buttonGreen);
			
			//Ajout des labels créés dynamiquement à la fenetre:
			mainPanel.add(panelPylons);
			
			this.setVisible(false);
			this.setVisible(true);
		}
	}
	
	private ActionListener createDynamicActionListeners(int pylonId, String colorButton)
	{
		ActionListener listenerButton = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					controller.getScriptReader().invokeButtonInput(pylonId, colorButton);
				}
				catch (NoSuchMethodException | ScriptException e1) 
				{
					e1.printStackTrace();
				}
			}
		};
		
		return listenerButton;
	}
}
