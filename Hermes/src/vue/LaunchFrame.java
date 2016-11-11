package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controler.MainController;
import modele.tools.Logger;

import javax.swing.JScrollBar;
import java.awt.Scrollbar;

public class LaunchFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField pathJavascript;
	private JPanel loadPanel;
	private JButton btnBrowseJavascript;
	private JPanel launchPanel;
	private JPanel statusPanel;
	private JLabel lblLoadJavascript;
	private JPanel panelLoadJavascript;
	private JPanel panelLoadXML;
	private JLabel lblLoadXML;
	private JTextField pathXML;
	private JButton btnBrowseXML;
	private JTextPane statusTextPane;
	private JButton btnLaunchScenario;
	
	private MainController controller;
	private JButton btnLoadJavascript;
	private JButton btnLoadXML;
	
	/**
	 * Create the frame.
	 */
	public LaunchFrame() {
		setTitle("Load and Launch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		loadPanel = new JPanel();
		loadPanel.setBorder(new TitledBorder(null, "Load", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(loadPanel);
		loadPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelLoadJavascript = new JPanel();
		loadPanel.add(panelLoadJavascript);
		
		lblLoadJavascript = new JLabel("Scenario Javascript File:");
		panelLoadJavascript.add(lblLoadJavascript);
		
		pathJavascript = new JTextField();
		pathJavascript.setEditable(false);
		panelLoadJavascript.add(pathJavascript);
		pathJavascript.setColumns(10);
		
		btnBrowseJavascript = new JButton("...");
		btnBrowseJavascript.addActionListener(this);
		panelLoadJavascript.add(btnBrowseJavascript);
		
		btnLoadJavascript = new JButton("Load");
		btnLoadJavascript.setEnabled(false);
		btnLoadJavascript.addActionListener(this);
		panelLoadJavascript.add(btnLoadJavascript);
		
		panelLoadXML = new JPanel();
		loadPanel.add(panelLoadXML);
		
		lblLoadXML = new JLabel("Entities XML File");
		
		pathXML = new JTextField();
		pathXML.setEditable(false);
		pathXML.setColumns(10);
		
		btnBrowseXML = new JButton("...");
		btnBrowseXML.addActionListener(this);
		panelLoadXML.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelLoadXML.add(lblLoadXML);
		panelLoadXML.add(pathXML);
		panelLoadXML.add(btnBrowseXML);
		
		btnLoadXML = new JButton("Load");
		btnLoadXML.setEnabled(false);
		btnLoadXML.addActionListener(this);
		panelLoadXML.add(btnLoadXML);
		
		launchPanel = new JPanel();
		launchPanel.setBorder(new TitledBorder(null, "Launch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(launchPanel);
		
		btnLaunchScenario = new JButton("Launch Scenario");
		btnLaunchScenario.addActionListener(this);
		launchPanel.add(btnLaunchScenario);
		
		statusPanel = new JPanel();
		statusPanel.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(statusPanel);
		statusPanel.setLayout(new BorderLayout(0, 0));
		
		statusTextPane = new JTextPane();
		statusPanel.add(statusTextPane);
		setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(btnBrowseJavascript))
		{
			JFileChooser fileChooserJavascript = new JFileChooser();
			fileChooserJavascript.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooserJavascript.setDialogTitle("Select Scenario Javascript File");
			fileChooserJavascript.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Javascript Files", "js");
			fileChooserJavascript.setFileFilter(filter);
			int result = fileChooserJavascript.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) 
			{
			    File selectedFile = fileChooserJavascript.getSelectedFile();
			    pathJavascript.setText(selectedFile.getName());
			    btnLoadJavascript.setEnabled(true);
			    Logger.insertString("Javascript Scenario File selected: "+selectedFile, "INFO", statusTextPane);
			}
		}
		else if (e.getSource().equals(btnBrowseXML))
		{
			JFileChooser fileChooserXML = new JFileChooser();
			fileChooserXML.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooserXML.setDialogTitle("Select Parameter XML File");
			fileChooserXML.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
			fileChooserXML.setFileFilter(filter);
			int result = fileChooserXML.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) 
			{
			    File selectedFile = fileChooserXML.getSelectedFile();
			    pathXML.setText(selectedFile.getName());
			    btnLoadXML.setEnabled(true);
			    Logger.insertString("XML Parameter File selected: "+selectedFile, "INFO", statusTextPane);
			}
		}
		else if (e.getSource().equals(btnLoadJavascript))
		{
			
		}
		else if (e.getSource().equals(btnLoadXML))
		{
			
		}
		else if (e.getSource().equals(btnLaunchScenario))
		{
			Logger.insertString("Launching scenario", "INFO", statusTextPane);
		}
	}
	
	public void addController(MainController controller)
	{
		this.controller = controller;
	}
}
