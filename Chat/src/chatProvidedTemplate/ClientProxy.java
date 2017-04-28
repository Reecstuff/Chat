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
	ServerGUI sgui;
	LocalTime lt = null;
		
	public ClientProxy(ServerGUI sgui)
	{
		this.sgui = sgui;
		start();
	}
	
	public ClientProxy(Socket s, ServerGUI sgui)
	{
		this.aSocket = s;
		this.sgui = sgui;
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
					bestimmeKommando(message);
				}
			}
			catch(IOException e)
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
			sgui.addMessage("<"+this.nick+">"+":"+buffer[1]);
		break;
		case "BYE":
			try
			{
				System.out.println("Beende Verbindung!");
				aSocket.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			break;
		case "USR":
			//TODO
		break;
		case "NCK":
			this.nick = buffer[1];
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
	protected void bearbeiteNachricht()
	{
		
	}
	protected void erstelleAblehnung()
	{
		
	}
	protected void beendeClientProxy()
	{
		
	}
	
	@Override
	public void run()
	{
		empfangeNachricht();		
	}
}
