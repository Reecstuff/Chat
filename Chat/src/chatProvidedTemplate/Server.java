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
	
	Actimal activate = new Actimal();
	
	int listtick = 0;
	
	public Server(int port)
	{
		this.port = port;
		System.setSecurityManager(activate);
	}
	public Actimal getActivate() {
		return activate;
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
	
	protected void warteAufClient()
	{
		try
		{
			while(!isInterrupted())
			{
				clientProxyList.add(new ClientProxy(aServerSocket.accept(), this));
				verteileNachricht("New arrival!");
				System.out.println("Connection accepted");
			}
		}
		catch(IOException e)
		{
			interrupt();
		}
		catch(SecurityException e)
		{
			System.out.println("Actimal activated");
		}
	}
	protected void verteileNachricht(String message)
	{
		aServerGUI.addMessage(message);
		tick();
		for(ClientProxy cp: clientProxyList)
		{
			cp.sendeNachricht("MSG\u001e"+message);
		}
	}
	protected void entferneClient(ClientProxy cproxy)
	{
		clientProxyList.remove(clientProxyList.indexOf(cproxy));
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
	
	protected String erstelleUserListe()
	{
		StringBuilder buffer = new StringBuilder();
		buffer.append("USR");
		for(ClientProxy cp : clientProxyList)
		{
			buffer.append("\u001e");
			buffer.append(cp.getNick());
		}
		return buffer.toString();
	}
	@Override
	public void interrupt()
	{
		super.interrupt();
		try
		{
			aServerSocket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void run()
	{
		warteAufClient();
	}
	
	private void tick()
	{
		if(listtick >= 100)
		{
			aServerGUI.getTextArea().removeAll();
			listtick = 0;
		}
		
		listtick++;
	}
}
