package chatProvidedTemplate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalTime;

public class ClientProxy extends Thread
{
	Socket aSocket;
	DataInputStream in;
	DataOutputStream out;
	String nick;
	LocalTime lt = null;
	Server aServer;	
	
	public ClientProxy(Socket s, Server aServer)
	{		
		this.aSocket = s;
		this.aServer = aServer;
		start();
	}
	public Socket getaSocket()
	{
		return aSocket;
	}
	public void setaSocket(Socket aSocket)
	{
		this.aSocket = aSocket;
	}
	public String getNick()
	{
		return nick;
	}
	public void setNick(String nick)
	{
		this.nick = nick;
	}
	public DataInputStream getIn()
	{
		return in;
	}
	public void setIn(DataInputStream in)
	{
		this.in = in;
	}
	public DataOutputStream getOut()
	{
		return out;
	}
	public void setOut(DataOutputStream out)
	{
		this.out = out;
	}
	protected void empfangeNachricht()
	{
		try
		{
			this.in = new DataInputStream(aSocket.getInputStream());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		while(!isInterrupted())
		{
			try
			{
				
				String message = in.readUTF();
				if(message != null)
				{
					aServer.getActivate().checkSpamAttack(aSocket.getInetAddress().toString());
					bestimmeKommando(message);
				}
			}
			catch(IOException e)
			{
				interrupt();
			}
			catch(SecurityException e)
			{
				System.out.println("Spamshield activated");
				beendeClientProxy();				
			}
		}
	}
	private void bestimmeKommando(String message)
	{
		String buffer[] = message.split("\u001e");
		switch(buffer[0])
		{
		case "MSG":
			if(aServer.getActivate().buffercheck(buffer, aSocket.getInetAddress().toString()))
			{
				aServer.verteileNachricht("<"+this.nick+">"+":"+buffer[1]);
			}
									
			break;
		case "BYE":
			beendeClientProxy();
			break;
		case "NCK":
			if(aServer.getActivate().buffercheck(buffer, aSocket.getInetAddress().toString()))
			{
				this.nick = buffer[1];
				sendeNachricht(aServer.erstelleUserListe());
			}			
			
			break;
		}
	}

	protected void sendeNachricht(String message)
	{
		try
		{
			if(out == null)
			{	
				out = new DataOutputStream(aSocket.getOutputStream());
			}
			out.writeUTF(message);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	protected void ermittleZeit()
	{
		lt = LocalTime.now();		
	}
	protected void beendeClientProxy()
	{
		try
		{
			System.out.println("Beende Verbindung!");
			interrupt();
			in.close();
			out.close();
			aSocket.close();
			aServer.entferneClient(this);
		} catch (IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	@Override
	public void run()
	{
		empfangeNachricht();		
	}
	
}
