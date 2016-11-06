package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import modele.scnObjects.Scenario;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.FlowLayout;

public class ScnControlFrame extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel panelPylon;
	private JPanel panelTeam;
	private JPanel panelPlayers;

	/**
	 * Create the frame.
	 */
	public ScnControlFrame() {
		setTitle("ScnControlFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelPylon = new JPanel();
		panelPylon.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pylons", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.add(panelPylon);
		panelPylon.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelTeam = new JPanel();
		panelTeam.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Teams", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.add(panelTeam);
		panelTeam.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelPlayers = new JPanel();
		panelPlayers.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainPanel.add(panelPlayers);
		panelPlayers.setLayout(new GridLayout(0, 1, 0, 0));
		setVisible(true);
	}
	
	public void update(Observable obs, Object obj) 
	{
		Scenario scenario = (Scenario) obj;
		
		//Affichage dynamique des Players:
		for (int i = 0 ; i < scenario.getNumberOfPlayers() ; i++)
		{
			int playerId = scenario.getPlayers()[i].getId();
			String playerName = scenario.getPlayers()[i].getName();
			
			JPanel panelPlayer = new JPanel();
			panelPlayer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Player no "+playerId, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelPlayer.setLayout(new GridLayout(0, 1, 0, 0));
			JLabel labelPlayerName = new JLabel("<html><u>Name:</u> "+playerName+"</html>");
			
			panelPlayer.add(labelPlayerName);
			
			//Ajout des labels créés dynamiquement à la fenetre:
			panelPlayers.add(panelPlayer);
		}
		
		System.out.println("----->" +scenario.getNumberOfPylons());
		
		//Affichage dynamique des Pylons:
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
			
			panelPylons.add(labelPlayerName);
			panelPylons.add(labelNbOwners);
			
			//Ajout des labels créés dynamiquement à la fenetre:
			panelPylon.add(panelPylons);
		}
		
		//Affichage dynamique des Teams:
		for (int i = 0 ; i < scenario.getNumberOfTeams() ; i++)
		{
			int teamId = scenario.getTeams()[i].getId();
			String teamName = scenario.getTeams()[i].getName();
			String teamShortName = scenario.getTeams()[i].getShortName();
			int teamNbPlayers = scenario.getTeams()[i].getNbPlayers();
			
			JPanel panelTeams = new JPanel();
			panelTeams.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pylon no "+teamId, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTeams.setLayout(new GridLayout(0, 1, 0, 0));
			JLabel labelTeamName = new JLabel("<html><u>Name:</u> "+teamName+"</html>");
			JLabel labelTeamShortName = new JLabel("<html><u>Short Name:</u> "+teamShortName+"</html>");
			JLabel labelTeamNbPlayers = new JLabel("<html><u>Nb Players:</u> "+teamNbPlayers+"</html>");
			
			panelTeams.add(labelTeamName);
			panelTeams.add(labelTeamShortName);
			panelTeams.add(labelTeamNbPlayers);
			
			//Ajout des joueurs:
			for (int j = 0 ; j < scenario.getTeams()[i].getPlayers().size() ; j++)
			{
				String playerName = scenario.getTeams()[i].getPlayers().get(j).getName();
				JLabel labelPlayerName = new JLabel("- "+playerName);
				panelTeams.add(labelPlayerName);
			}
			
			
			//Ajout des labels créés dynamiquement à la fenetre:
			panelTeam.add(panelTeams);
		}
	}
	
	public void addController(ActionListener controller)
	{
		//button.addActionListener(controller);
	}
}
