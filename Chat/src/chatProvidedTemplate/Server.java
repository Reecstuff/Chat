package chatProvidedTemplate;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread
{
	int port;
	String meldung;
	ServerSocket aServerSocket;
	ServerGUI aServerGUI;
	ArrayList <ClientProxy> clientProxyList = new ArrayList<ClientProxy>();
	
	public Server(int port)
	{
		this.port = port;
	}
	public ServerGUI getaServerGUI()
	{
		return aServerGUI;
	}
	public void setaServerGUI(ServerGUI aServerGUI)
	{
		this.aServerGUI = aServerGUI;
	}
	public ServerSocket getaServerSocket()
	{
		return aServerSocket;
	}
	public void setaServerSocket(ServerSocket aServerSocket)
	{
		this.aServerSocket = aServerSocket;
	}
	public ArrayList<ClientProxy> getClientProxyList()
	{
		return clientProxyList;
	}
	public void setClientProxyList(ArrayList<ClientProxy> clientProxyList)
	{
		this.clientProxyList = clientProxyList;
	}
	public int getPort()
	{
		return port;
	}
	public void setPort(int port)
	{
		this.port = port;
	}
	public String getMeldung()
	{
		return meldung;
	}
	public void setMeldung(String meldung)
	{
		this.meldung = meldung;
	}
	
	protected void aufnehmenClient()
	{
		
	}
	protected void warteAufClient()
	{
		try
		{
			while(!isInterrupted())
			{
				clientProxyList.add(new ClientProxy(aServerSocket.accept(), aServerGUI));
				verteileNachricht("MSG\u001eNew arrival!");
				System.out.println("Connection accepted");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}			
	}
	protected void verteileNachricht(String message)
	{
		for(ClientProxy cp: clientProxyList)
		{
			cp.sendeNachricht(message);
		}
	}
	protected void entferneClient()
	{
		
	}
	protected void starteServer()
	{
		try
		{
			aServerSocket = new ServerSocket(port);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	protected void beendeServer()
	{
		aServerSocket = null;
		clientProxyList.clear();
		this.interrupt();
	}
	protected void pruefeAnmeldung()
	{
		
	}
	protected void erstelleUserListe()
	{
		for(ClientProxy cp : clientProxyList)
		{
			cp.getNick();
		}
		
	}
	@Override
	public void run()
	{
		warteAufClient();
	}
}
