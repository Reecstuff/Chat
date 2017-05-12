package chatProvidedTemplate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerGUI extends JFrame
{Server aServer;
	/**
	 * 
	 */
	private static final long serialVersionUID = -6368058319536917111L;
	private JPanel contentPane;
	private Label labelNachrichten;
	private java.awt.List List;
	private Label labelPort;
	private TextField textFieldPortNr;
	private Button buttonStart;
	private TextField textFieldMsgEingabe;
	private Label labelConnectionShow;
	private Button buttonStop;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{38, 324, 47, 98, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 37, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_labelNachrichten = new GridBagConstraints();
		gbc_labelNachrichten.gridwidth = 3;
		gbc_labelNachrichten.insets = new Insets(0, 0, 5, 5);
		gbc_labelNachrichten.gridx = 0;
		gbc_labelNachrichten.gridy = 0;
		contentPane.add(getLabelNachrichten(), gbc_labelNachrichten);
		GridBagConstraints gbc_labelPort = new GridBagConstraints();
		gbc_labelPort.insets = new Insets(0, 0, 5, 0);
		gbc_labelPort.gridx = 3;
		gbc_labelPort.gridy = 0;
		contentPane.add(getLabelPort(), gbc_labelPort);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.gridheight = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		contentPane.add(getTextArea(), gbc_textArea);
		GridBagConstraints gbc_textFieldPortNr = new GridBagConstraints();
		gbc_textFieldPortNr.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPortNr.fill = GridBagConstraints.BOTH;
		gbc_textFieldPortNr.gridx = 3;
		gbc_textFieldPortNr.gridy = 1;
		contentPane.add(getTextFieldPortNr(), gbc_textFieldPortNr);
		getButtonStart().setVisible(true);
		getButtonStart().setEnabled(false);
		GridBagConstraints gbc_buttonStart = new GridBagConstraints();
		gbc_buttonStart.insets = new Insets(0, 0, 5, 0);
		gbc_buttonStart.fill = GridBagConstraints.BOTH;
		gbc_buttonStart.gridx = 3;
		gbc_buttonStart.gridy = 2;
		contentPane.add(getButtonStart(), gbc_buttonStart);
		GridBagConstraints gbc_buttonStop = new GridBagConstraints();
		gbc_buttonStop.fill = GridBagConstraints.BOTH;
		gbc_buttonStop.insets = new Insets(0, 0, 5, 0);
		gbc_buttonStop.gridx = 3;
		gbc_buttonStop.gridy = 3;
		contentPane.add(getButtonStop(), gbc_buttonStop);
		GridBagConstraints gbc_textFieldMsgEingabe = new GridBagConstraints();
		gbc_textFieldMsgEingabe.fill = GridBagConstraints.BOTH;
		gbc_textFieldMsgEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMsgEingabe.gridx = 1;
		gbc_textFieldMsgEingabe.gridy = 5;
		contentPane.add(getTextFieldMsgEingabe(), gbc_textFieldMsgEingabe);
		GridBagConstraints gbc_labelConnectionShow = new GridBagConstraints();
		gbc_labelConnectionShow.insets = new Insets(0, 0, 0, 5);
		gbc_labelConnectionShow.gridx = 1;
		gbc_labelConnectionShow.gridy = 6;
		contentPane.add(getLabelConnectionShow(), gbc_labelConnectionShow);
		getLabelConnectionShow().setVisible(false);
	}

	private Label getLabelNachrichten() {
		if (labelNachrichten == null) {
			labelNachrichten = new Label("Nachrichten!");
			labelNachrichten.setFont(new Font("Dialog", Font.BOLD, 17));
		}
		return labelNachrichten;
	}
	public java.awt.List getTextArea() {
		if (List == null) {
			List = new java.awt.List();
		}
		return List;
	}
	private Label getLabelPort() {
		if (labelPort == null) {
			labelPort = new Label("Portnr.:");
			labelPort.setFont(new Font("Dialog", Font.BOLD, 17));
		}
		return labelPort;
	}
	private TextField getTextFieldPortNr() {
		if (textFieldPortNr == null) {
			textFieldPortNr = new TextField();
			textFieldPortNr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonStart.setEnabled(true);					
				}
			});
		}
		return textFieldPortNr;
	}
	private Button getButtonStart() {
		if (buttonStart == null) {
			buttonStart = new Button("Start");
			buttonStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					startServer();					
				}
			});
			buttonStart.setFont(new Font("Dialog", Font.BOLD, 15));
		}
		return buttonStart;
	}

	private TextField getTextFieldMsgEingabe() {
		if (textFieldMsgEingabe == null) {
			textFieldMsgEingabe = new TextField();
			textFieldMsgEingabe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return textFieldMsgEingabe;
	}

	private Label getLabelConnectionShow() {
		if (labelConnectionShow == null) {
			labelConnectionShow = new Label("Server l\u00E4uft auf: XXXX.XX.XX.XX");
			labelConnectionShow.setEnabled(false);
		}
		return labelConnectionShow;
	}
	private Button getButtonStop() {
		if (buttonStop == null) {
			buttonStop = new Button("Stop");
			buttonStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					stoppeServer();
				}
			});
		}
		return buttonStop;
	}

	protected void startServer()
	{
		List.add("Start Server. Listening for requests...");
		aServer = new Server(Integer.parseInt(textFieldPortNr.getText()));
		aServer.setaServerGUI(this);
		aServer.starteServer();
		aServer.start();
	}
	protected void addMessage(String message)
	{
		List.add(message);
	}
	protected void stoppeServer()
	{
		List.removeAll();
		textFieldPortNr.setText("");
		textFieldPortNr.requestFocus();
		aServer.interrupt();
	}
}
