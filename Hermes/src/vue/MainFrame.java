package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;

import controler.MainController;

public class MainFrame extends JFrame implements ActionListener{

	private MainController controller;
	private File fileChoosed;
	
	private JPanel contentPane;
	private JLabel lblFileName;
	private JButton btnLoad;
	private JButton btnBlack;
	private JLabel lblBlack;
	private JButton btnRed;
	private JLabel lblRed;
	private JButton btnEval;
	
	/**
	 * Create the frame.
	 */
	public MainFrame(MainController controller) {
		
		setTitle("HERMES AAC");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelFileChooser = new JPanel();
		panelFileChooser.setBackground(Color.GRAY);
		panelMain.add(panelFileChooser, BorderLayout.NORTH);
		
		lblFileName = new JLabel("");
		panelFileChooser.add(lblFileName);
		
		btnLoad = new JButton("Load");
		btnLoad.addActionListener(this);
		panelFileChooser.add(btnLoad);
		
		btnEval = new JButton("Eval");
		btnEval.addActionListener(this);
		panelFileChooser.add(btnEval);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(Color.LIGHT_GRAY);
		panelMain.add(panelStatus, BorderLayout.CENTER);
		panelStatus.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelButtonBlack = new JPanel();
		panelStatus.add(panelButtonBlack);
		
		btnBlack = new JButton("Black");
		panelButtonBlack.add(btnBlack);
		
		lblBlack = new JLabel("Black");
		panelButtonBlack.add(lblBlack);
		
		JPanel panelButtonRed = new JPanel();
		panelStatus.add(panelButtonRed);
		
		btnRed = new JButton("Red");
		panelButtonRed.add(btnRed);
		
		lblRed = new JLabel("Red");
		panelButtonRed.add(lblRed);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(btnLoad))
		{
			JFileChooser scenarioFileChooser = new JFileChooser();
			scenarioFileChooser.setDialogTitle("Select Javascript Scenario File");
			scenarioFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			scenarioFileChooser.setCurrentDirectory(scenarioFileChooser.getCurrentDirectory());
			File workingDirectory = new File(System.getProperty("user.dir"));
			scenarioFileChooser.setCurrentDirectory(workingDirectory);
			FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Javascript Scenario Files", "js", "xml");
			scenarioFileChooser.setFileFilter(fileFilter);
			
			int returnVal = scenarioFileChooser.showOpenDialog(MainFrame.this);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				fileChoosed = scenarioFileChooser.getSelectedFile();
				lblFileName.setText(fileChoosed.getName());
			} else 
			{

			}
		}
		else if (e.getSource().equals(btnEval))
		{
			System.out.println("EVALUTATION OF "+fileChoosed+" FILE.");
		}
	}
	
	

}
