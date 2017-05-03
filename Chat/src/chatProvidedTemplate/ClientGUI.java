package chatProvidedTemplate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Button;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;

public class ClientGUI extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2279945557995671571L;
	private JPanel contentPane;
	private Button buttonStart;
	private Label labelServer;
	private TextField textFieldMessage;
	Client aClient;
	private TextField textField;
	private Label label;
	private TextField textFieldNick;
	private List nachrichtenliste;
	private List nutzerliste;
	private Label label_1;
	private Button button;

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
					ClientGUI frame = new ClientGUI();
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
	public ClientGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 184, 0, 0, 292, 144, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_labelServer = new GridBagConstraints();
		gbc_labelServer.anchor = GridBagConstraints.WEST;
		gbc_labelServer.insets = new Insets(0, 0, 5, 5);
		gbc_labelServer.gridx = 1;
		gbc_labelServer.gridy = 0;
		contentPane.add(getLabelServer(), gbc_labelServer);
		GridBagConstraints gbc_nachrichtenliste = new GridBagConstraints();
		gbc_nachrichtenliste.gridheight = 6;
		gbc_nachrichtenliste.fill = GridBagConstraints.BOTH;
		gbc_nachrichtenliste.insets = new Insets(0, 0, 5, 5);
		gbc_nachrichtenliste.gridx = 4;
		gbc_nachrichtenliste.gridy = 0;
		contentPane.add(getNachrichtenliste(), gbc_nachrichtenliste);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 0;
		contentPane.add(getLabel_1(), gbc_label_1);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(getTextField(), gbc_textField);
		GridBagConstraints gbc_buttonStart = new GridBagConstraints();
		gbc_buttonStart.insets = new Insets(0, 0, 5, 5);
		gbc_buttonStart.gridx = 3;
		gbc_buttonStart.gridy = 1;
		contentPane.add(getButtonStart(), gbc_buttonStart);
		GridBagConstraints gbc_nutzerliste = new GridBagConstraints();
		gbc_nutzerliste.fill = GridBagConstraints.BOTH;
		gbc_nutzerliste.gridheight = 6;
		gbc_nutzerliste.gridx = 5;
		gbc_nutzerliste.gridy = 1;
		contentPane.add(getNutzerliste(), gbc_nutzerliste);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		contentPane.add(getLabel(), gbc_label);
		GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
		gbc_textFieldNick.fill = GridBagConstraints.BOTH;
		gbc_textFieldNick.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNick.gridx = 1;
		gbc_textFieldNick.gridy = 3;
		contentPane.add(getTextFieldNick(), gbc_textFieldNick);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 4;
		contentPane.add(getButton(), gbc_button);
		GridBagConstraints gbc_textFieldMessage = new GridBagConstraints();
		gbc_textFieldMessage.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMessage.gridx = 4;
		gbc_textFieldMessage.gridy = 6;
		contentPane.add(getTextFieldMessage(), gbc_textFieldMessage);
	}
	private Button getButtonStart() {
		if (buttonStart == null) {
			buttonStart = new Button("Start");
			buttonStart.setEnabled(false);
			buttonStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					connect();	
				}
			});
		}
		return buttonStart;
	}

	private Label getLabelServer() {
		if (labelServer == null) {
			labelServer = new Label("Server");
		}
		return labelServer;
	}
	private TextField getTextFieldMessage() {
		if (textFieldMessage == null) {
			textFieldMessage = new TextField();
			textFieldMessage.setEnabled(false);
			textFieldMessage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sendMessage();
				}
			});
		}
		return textFieldMessage;
	}

	private TextField getTextField() {
		if (textField == null) {
			textField = new TextField();
			textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonStart.setEnabled(true);
				}
			});
		}
		return textField;
	}
	private Label getLabel() {
		if (label == null) {
			label = new Label("Nick");
		}
		return label;
	}
	private TextField getTextFieldNick() {
		if (textFieldNick == null) {
			textFieldNick = new TextField();
			textFieldNick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sendeNickname();
				}
			});
		}
		return textFieldNick;
	}
	protected void sendeNickname()
	{
		aClient.sendeNachricht("NCK"+ "\u001e" + textFieldNick.getText());
	}

	private List getNachrichtenliste() {
		if (nachrichtenliste == null) {
			nachrichtenliste = new List();
		}
		return nachrichtenliste;
	}
	private List getNutzerliste() {
		if (nutzerliste == null) {
			nutzerliste = new List();
		}
		return nutzerliste;
	}
	private Label getLabel_1() {
		if (label_1 == null) {
			label_1 = new Label("Nutzer online");
		}
		return label_1;
	}
	private Button getButton() {
		if (button == null) {
			button = new Button("Stop");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aClient.beendeClient();
				}
			});
			button.setEnabled(false);
		}
		return button;
	}
	public void addNachricht(String message)
	{
		nachrichtenliste.add(message);
	}
	protected void sendMessage()
	{
		aClient.sendeNachricht("MSG"+"\u001e" + textFieldMessage.getText());
		textFieldMessage.setText("");
	}
	protected void connect()
	{
		textFieldMessage.setEnabled(true);
		button.setEnabled(true);
		String array[] = new String[2];
		aClient = new Client();
		aClient.setaClientGUI(this);
		array = textField.getText().split(":");
		try{
			aClient.anmelden(array[0], Integer.parseInt(array[1]));
			buttonStart.setEnabled(false);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Syntax: <ip>:<port>");
			return;
		}
		aClient.start();
	}

	public void addMessage(String string)
	{
		nachrichtenliste.add(string);
	}
}
