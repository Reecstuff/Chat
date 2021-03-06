package chatProvidedTemplate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread
{
	DataOutputStream out;
	DataInputStream in;
	String message;
	Socket aSocket;
	ClientGUI aClientGUI;
	
	public ClientGUI getaClientGUI()
	{
		return aClientGUI;
	}

	public void setaClientGUI(ClientGUI aClientGUI)
	{
		this.aClientGUI = aClientGUI;
	}

	public Client()
	{}
	
	protected void empfangeNachricht()
	{
		while(!isInterrupted())
		{
			try
			{
				if(in == null)
				{
					in = new DataInputStream(aSocket.getInputStream());		
				}
				message = in.readUTF();
				bestimmeKommando(message);
			} catch (IOException e)
			{
				interrupt();
			}
		}
	}
	private void bestimmeKommando(String message)
	{
		String buffer[] = message.split("\u001e");
		switch(buffer[0])
		{
		case "MSG":
			aClientGUI.addNachricht(buffer[1]);
		break;
		case "BYE":
			try
			{
				System.out.println("Beende Verbindung!");
				in.close();
				out.close();
				aSocket.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			break;
		case "USR":
			for(int i = 1; i < buffer.length; i++)
			{
				aClientGUI.addUser(buffer[i]);
			}
		break;
		}
	}
	protected void sendeNachricht(String string)
	{
		try
		{
			out = new DataOutputStream(aSocket.getOutputStream());
			out.writeUTF(string);
		} catch (IOException e)
		{
			System.out.print("Fehler beim schreiben!");
		}		
	}
	protected void anmelden(String ip, int port)
	{
		erzeugeSocket(ip, port);
		try
		{
			in = new DataInputStream(aSocket.getInputStream());
		} catch (IOException e)
		{
			System.out.println("Fehler beim Erstellen des DIS beim Anmelden!");
			return;
		}
	}
	protected void erzeugeSocket(String ip, int port)
	{
		try
		{
			aSocket = new Socket(ip, port);
		} catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
	protected void beendeClient()
	{
		sendeNachricht("BYE");
		try
		{
			interrupt();
			out.close();
			in.close();
			aSocket.close();
			aClientGUI.dispose();
		} catch (IOException e)
		{
			System.out.println("Fehler beim Schlie�en");
		}
	}
	@Override
	public void run()
	{
		empfangeNachricht();
	}
}
