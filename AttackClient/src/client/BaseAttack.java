package client;

import java.io.IOException;

public abstract class BaseAttack implements Attack
{
	protected BaseAttack(String host, int port)
	{
		this.host = host;
		this.port = port;
	}
	
	protected final String host;
	protected final int port;
	
	@Override
	public void run()
	{
		try
		{
			execute();
		}
		catch(IOException e) { };
	}	
}
