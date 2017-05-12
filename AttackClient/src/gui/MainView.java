package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import client.AttackScaler;
import client.InfiniteDroppedConnectionAttack;
import client.InvalidPayloadAttack;
import client.LinearSpamAttack;
import client.WordlistSpamAttack;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView
{
	
	private JFrame frame;
	private JTextField tfPort;
	private JComboBox<Target> cbTarget;
	
	private JButton btnInifiniteDroppedConnection;
	private JButton btnInvalidPayload;
	private JButton btnLinearSpam;
	private JButton btnWordlistSpam;

	AttackScaler infiniteDroppedConnectionAttackScaler = new AttackScaler();
	AttackScaler invalidPayloadScaler = new AttackScaler();
	AttackScaler linearSpamScaler = new AttackScaler();
	AttackScaler wordlistSpamScaler = new AttackScaler();
	
	private void infiniteConnectionAttackAction()
	{
		if(infiniteDroppedConnectionAttackScaler.isRunning())
		{
			getBtnInifiniteDroppedConnection().setText("Infinite Dropped Connection");
			infiniteDroppedConnectionAttackScaler.stop();
		}
		else
		{
			getBtnInifiniteDroppedConnection().setText("stop");
			infiniteDroppedConnectionAttackScaler.scale(
					new InfiniteDroppedConnectionAttack(
							getSelectedTarget().Host,
							Integer.parseInt(tfPort.getText())
					),
					8
		  );
		}
	}

	private void invalidPayloadAttackAction()
	{
		if(invalidPayloadScaler.isRunning())
		{
			getBtnInvalidPayload().setText("Invalid Payload");
			invalidPayloadScaler.stop();
		}
		else
		{
			getBtnInvalidPayload().setText("stop");
			invalidPayloadScaler.scale(
					new InvalidPayloadAttack(
							getSelectedTarget().Host,
							Integer.parseInt(tfPort.getText())
					),
					1
			);
		}
	}

	private void linearSpamAction()
	{
		if(linearSpamScaler.isRunning())
		{
			getBtnLinearSpam().setText("Linear Spam");
			linearSpamScaler.stop();
		}
		else
		{
			getBtnLinearSpam().setText("stop");
			linearSpamScaler.scale(
				new LinearSpamAttack(
					getSelectedTarget().Host,
					Integer.parseInt(tfPort.getText()),
					"PWNED BY YOUR KAPPA",
					"Kappa"
				),
				2
			);
		}
	}
	
	private void wordlistSpamAction()
	{
		if(wordlistSpamScaler.isRunning())
		{
			getBtnWordlistSpam().setText("Wordlist Spam");
			wordlistSpamScaler.stop();
		}
		else
		{
			getBtnWordlistSpam().setText("stop");
			wordlistSpamScaler.scale(
				new WordlistSpamAttack(
					getSelectedTarget().Host,
					Integer.parseInt(tfPort.getText())
				),
				2
			);
		}
	}
	
	private Target getSelectedTarget()
	{
		return getCbTarget().getModel().getElementAt(getCbTarget().getSelectedIndex());
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(
				new Runnable()
				{
					public void run()
					{
						try
						{
							MainView window = new MainView();
							window.frame.setVisible(true);
						} catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				}
		);
	}
	
	/**
	 * Create the application.
	 */
	public MainView()
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 203);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_cbTarget = new GridBagConstraints();
		gbc_cbTarget.gridwidth = 3;
		gbc_cbTarget.insets = new Insets(0, 0, 5, 5);
		gbc_cbTarget.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTarget.gridx = 0;
		gbc_cbTarget.gridy = 0;
		frame.getContentPane().add(getCbTarget(), gbc_cbTarget);
		GridBagConstraints gbc_tfPort = new GridBagConstraints();
		gbc_tfPort.insets = new Insets(0, 0, 5, 0);
		gbc_tfPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPort.gridx = 3;
		gbc_tfPort.gridy = 0;
		frame.getContentPane().add(getTfPort(), gbc_tfPort);
		GridBagConstraints gbc_btnInifiniteDroppedConnection = new GridBagConstraints();
		gbc_btnInifiniteDroppedConnection.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInifiniteDroppedConnection.insets = new Insets(0, 0, 5, 5);
		gbc_btnInifiniteDroppedConnection.gridx = 0;
		gbc_btnInifiniteDroppedConnection.gridy = 1;
		frame.getContentPane().add(getBtnInifiniteDroppedConnection(), gbc_btnInifiniteDroppedConnection);
		GridBagConstraints gbc_btnInvalidPayload = new GridBagConstraints();
		gbc_btnInvalidPayload.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInvalidPayload.insets = new Insets(0, 0, 5, 5);
		gbc_btnInvalidPayload.gridx = 0;
		gbc_btnInvalidPayload.gridy = 2;
		frame.getContentPane().add(getBtnInvalidPayload(), gbc_btnInvalidPayload);
		GridBagConstraints gbc_btnLinearSpam = new GridBagConstraints();
		gbc_btnLinearSpam.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLinearSpam.insets = new Insets(0, 0, 5, 5);
		gbc_btnLinearSpam.gridx = 0;
		gbc_btnLinearSpam.gridy = 3;
		frame.getContentPane().add(getBtnLinearSpam(), gbc_btnLinearSpam);
		GridBagConstraints gbc_btnWordlistSpam = new GridBagConstraints();
		gbc_btnWordlistSpam.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnWordlistSpam.insets = new Insets(0, 0, 0, 5);
		gbc_btnWordlistSpam.gridx = 0;
		gbc_btnWordlistSpam.gridy = 4;
		frame.getContentPane().add(getBtnWordlistSpam(), gbc_btnWordlistSpam);
	}
	private JTextField getTfPort() {
		if (tfPort == null) {
			tfPort = new JTextField();
			tfPort.setText("8008");
			tfPort.setColumns(10);
		}
		return tfPort;
	}
	
	private JComboBox<Target> getCbTarget() {
		if (cbTarget == null) {
			Vector<Target> t = new Vector<Target>();
			t.add(new Target("Maxi", "172.16.100.5"));
			t.add(new Target("Christian", "172.16.102.8"));
			
			cbTarget = new JComboBox<Target>(t);
		}
		return cbTarget;
	}
	private JButton getBtnInifiniteDroppedConnection() {
		if (btnInifiniteDroppedConnection == null) {
			btnInifiniteDroppedConnection = new JButton("Inifinite Dropped Connection");
			btnInifiniteDroppedConnection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					infiniteConnectionAttackAction();
				}
			});
		}
		return btnInifiniteDroppedConnection;
	}
	private JButton getBtnInvalidPayload() {
		if (btnInvalidPayload == null) {
			btnInvalidPayload = new JButton("Invalid Payload");
			btnInvalidPayload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					invalidPayloadAttackAction();
				}
			});
		}
		return btnInvalidPayload;
	}
	private JButton getBtnLinearSpam() {
		if (btnLinearSpam == null) {
			btnLinearSpam = new JButton("Linear Spam");
			btnLinearSpam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					linearSpamAction();
				}
			});
		}
		return btnLinearSpam;
	}
	private JButton getBtnWordlistSpam() {
		if (btnWordlistSpam == null) {
			btnWordlistSpam = new JButton("Wordlist Spam");
			btnWordlistSpam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					wordlistSpamAction();
				}
			});
		}
		return btnWordlistSpam;
	}
}
